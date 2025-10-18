package fi.joonasniemi.trainingtracker.feature.activeexercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetType
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetTypeEnum
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate
import fi.joonasniemi.trainingtracker.core.ui.ListItemWrapper
import fi.joonasniemi.trainingtracker.core.ui.ListItemWrapperDefaults
import org.koin.androidx.compose.koinViewModel
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Composable
fun ActiveExerciseScreen(
    viewModel: ActiveExerciseViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val exercise by viewModel.exercise.collectAsStateWithLifecycle()

    ActiveExerciseScreen(
        onAction = viewModel::onAction,
        state = state,
        exercise = exercise,
    )
}

@Composable
internal fun ActiveExerciseScreen(
    onAction: (ActiveExerciseAction) -> Unit,
    state: ActiveExerciseState,
    exercise: Exercise?,
) {
    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            exercise?.exerciseTemplate?.type?.let { type ->
                ExerciseSetControls(
                    exerciseSetType = type,
                    onAddNewSet = {
                        onAction(ActiveExerciseAction.AddNewSet(it))
                    },
                )
            }
            exercise?.sets.orEmpty().forEach {
                key(it.id) {
                    SetItem(
                        exerciseSet = it,
                        onRemove = {
                            onAction(ActiveExerciseAction.DeleteSet(it))
                        },
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalUuidApi::class)
@Composable
private fun ExerciseSetControls(
    exerciseSetType: ExerciseSetTypeEnum,
    onAddNewSet: (ExerciseSet) -> Unit,
    modifier: Modifier = Modifier,
) {
    val controls = rememberSetControls(exerciseSetType)

    var repsTextField by remember { mutableStateOf(TextFieldValue()) }
    var weightTextField by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (controls.contains(SetControl.WEIGHT)) {
            InputWrapper(
                label = "Weight (kg)",
                value = weightTextField,
                onValueChange = {
                    if (!it.text.matches(doubleRegex)) return@InputWrapper
                    weightTextField = it
                },
                onAdd = {
                    val weight = weightTextField.text.toDoubleOrNull() ?: 0.0
                    weightTextField = weightTextField.copy(text = (weight + 2.5).toString())
                },
                onRemove = {
                    val weight = weightTextField.text.toDoubleOrNull() ?: 0.0
                    weightTextField = weightTextField
                        .copy(text = (weight - 2.5).coerceAtLeast(0.0).toString())
                },
                modifier = modifier,
            )
        }

        if (controls.contains(SetControl.REPS)) {
            InputWrapper(
                label = "Reps",
                value = repsTextField,
                onValueChange = {
                    if (!it.text.matches(intRegex)) return@InputWrapper
                    repsTextField = it
                },
                onAdd = {
                    val reps = repsTextField.text.toIntOrNull() ?: 0
                    repsTextField = repsTextField.copy(text = (reps + 1).toString())
                },
                onRemove = {
                    val reps = repsTextField.text.toIntOrNull() ?: 0
                    repsTextField = repsTextField
                        .copy(text = (reps - 1).coerceAtLeast(0).toString())
                },
                modifier = modifier,
            )
        }

        Button(
            onClick = {
                val reps = repsTextField.text.toIntOrNull() ?: 0
                val weight = weightTextField.text.toDoubleOrNull() ?: 0.0

                onAddNewSet(
                    ExerciseSet(
                        id = Uuid.random().toString(),
                        exerciseId = "1",
                        type = when (exerciseSetType) {
                            ExerciseSetTypeEnum.REPS -> ExerciseSetType.Reps(reps)
                            ExerciseSetTypeEnum.TIME -> ExerciseSetType.Time(0)
                            ExerciseSetTypeEnum.DISTANCE -> ExerciseSetType.Distance(0.0)
                            ExerciseSetTypeEnum.WEIGHT_AND_REPS -> ExerciseSetType.WeightAndReps(weight, reps)
                            ExerciseSetTypeEnum.TIME_AND_WEIGHT -> ExerciseSetType.TimeAndWeight(weight, 0)
                        },
                    )
                )
            }
        ) {
            Text(stringResource(fi.joonasniemi.trainingtracker.assets.R.string.assets_add))
        }
    }
}

private val intRegex = "^\\d{0,5}$".toRegex()
private val doubleRegex = "^(\\d{1,5}(\\.\\d{0,2})?|\\.\\d{0,2})?$".toRegex()

@Composable
private fun InputWrapper(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
        )
        HorizontalDivider(
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            IconButton(
                onClick = onRemove,
            ) {
                Icon(
                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_remove_24),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier.sizeIn(maxWidth = 100.dp),
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
            IconButton(
                onClick = onAdd,
            ) {
                Icon(
                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_baseline_add_24),
                    contentDescription = null,
                )
            }
        }
    }
}

private enum class SetControl {
    WEIGHT,
    TIME,
    REPS,
    DISTANCE,
}

@Composable
private fun rememberSetControls(exerciseSetType: ExerciseSetTypeEnum): List<SetControl> {
    return remember(exerciseSetType) {
        when (exerciseSetType) {
            ExerciseSetTypeEnum.REPS -> listOf(SetControl.REPS)
            ExerciseSetTypeEnum.TIME -> listOf(SetControl.TIME)
            ExerciseSetTypeEnum.DISTANCE -> listOf(SetControl.DISTANCE)
            ExerciseSetTypeEnum.WEIGHT_AND_REPS -> listOf(SetControl.WEIGHT, SetControl.REPS)
            ExerciseSetTypeEnum.TIME_AND_WEIGHT -> listOf(SetControl.TIME, SetControl.WEIGHT)
        }
    }
}

@Composable
private fun SetItem(
    exerciseSet: ExerciseSet,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val values = rememberExerciseSetTypeValues(exerciseSet.type)
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.EndToStart) onRemove()
            it != SwipeToDismissBoxValue.StartToEnd
        }
    )

    SwipeToDismissBox(
        state = swipeToDismissBoxState,
        backgroundContent = {
            when (swipeToDismissBoxState.dismissDirection) {
                SwipeToDismissBoxValue.EndToStart -> {
                    Icon(
                        painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_delete_24),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red, ListItemWrapperDefaults.shape)
                            .wrapContentSize(Alignment.CenterEnd)
                            .padding(12.dp),
                        tint = Color.White
                    )
                }

                else -> {}
            }
        },
    ) {
        ListItemWrapper(
            onClick = {},
            enabled = false,
            modifier = modifier,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (values.weight != null) {
                    WeightElement(
                        value = values.weight,
                        modifier = Modifier.weight(1f),
                    )
                }
                if (values.reps != null) {
                    RepsElement(
                        value = values.reps,
                        modifier = Modifier.weight(1f),
                    )
                }
                if (values.time != null) {
                    TimeElement(
                        value = values.time,
                        modifier = Modifier.weight(1f),
                    )
                }
                if (values.meters != null) {
                    DistanceElement(
                        value = values.meters,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun WeightElement(
    value: Double,
    modifier: Modifier = Modifier,
) {
    ElementContainer(
        modifier = modifier,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.alignByBaseline(),
        )
        Text(
            text = "kg",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alignByBaseline(),
        )
    }
}

@Composable
private fun RepsElement(
    value: Int,
    modifier: Modifier = Modifier,
) {
    ElementContainer(
        modifier = modifier,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.alignByBaseline(),
        )
        Text(
            text = "reps",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alignByBaseline(),
        )
    }
}

@Composable
private fun TimeElement(
    value: Long,
    modifier: Modifier = Modifier,
) {
    ElementContainer(
        modifier = modifier,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.alignByBaseline(),
        )
        Text(
            text = "ms",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alignByBaseline(),
        )
    }
}

@Composable
private fun DistanceElement(
    value: Double,
    modifier: Modifier = Modifier,
) {
    ElementContainer(
        modifier = modifier,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.alignByBaseline(),
        )
        Text(
            text = "m",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alignByBaseline(),
        )
    }
}

@Composable
private fun ElementContainer(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier,
        content = content,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    )
}

@Composable
private fun rememberExerciseSetTypeValues(type: ExerciseSetType): ExerciseSetTypeValues {
    return remember {
        when (type) {
            is ExerciseSetType.Reps -> ExerciseSetTypeValues(
                reps = type.reps,
            )

            is ExerciseSetType.Time -> ExerciseSetTypeValues(
                time = type.millis,
            )

            is ExerciseSetType.Distance -> ExerciseSetTypeValues(
                meters = type.meters,
            )

            is ExerciseSetType.WeightAndReps -> ExerciseSetTypeValues(
                weight = type.weight,
                reps = type.reps,
            )

            is ExerciseSetType.TimeAndWeight -> ExerciseSetTypeValues(
                time = type.millis,
                weight = type.weight,
            )
        }
    }
}

private data class ExerciseSetTypeValues(
    val weight: Double? = null,
    val reps: Int? = null,
    val meters: Double? = null,
    val time: Long? = null,
)

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun ActiveExerciseScreenPreview() {
    TrainingTrackerTheme {
        ActiveExerciseScreen(
            onAction = {},
            state = ActiveExerciseState(),
            exercise = Exercise(
                id = "1",
                timestamp = Clock.System.now(),
                exerciseTemplate = ExerciseTemplate(
                    id = "template",
                    name = "Exercise",
                    category = "back",
                    type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
                ),
                sets = listOf(
                    ExerciseSet(
                        id = "s1",
                        exerciseId = "1",
                        type = ExerciseSetType.WeightAndReps(24.0, 6)
                    )
                ),
            )
        )
    }
}