package fi.joonasniemi.trainingtracker.feature.exercises

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.ui.ListItemWrapper
import fi.joonasniemi.trainingtracker.core.ui.formatTime
import org.koin.androidx.compose.koinViewModel
import kotlin.time.ExperimentalTime

@Composable
fun ExercisesScreen(
    navigateToExercise: (String) -> Unit,
    viewModel: ExercisesViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val exercises by viewModel.exercises.collectAsStateWithLifecycle()

    ExercisesScreen(
        onAction = viewModel::onAction,
        state = state,
        exercises = exercises,
        navigateToExercise = navigateToExercise,
    )
}

@Composable
internal fun ExercisesScreen(
    onAction: (ExercisesAction) -> Unit,
    state: ExercisesState,
    navigateToExercise: (String) -> Unit,
    exercises: List<Exercise>,
) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = exercises,
                key = { it.id },
            ) {
                ExerciseItem(
                    exercise = it,
                    onClick = { navigateToExercise(it.id) },
                )
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
private fun ExerciseItem(
    exercise: Exercise,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val exerciseCount = remember(exercise.sets.size) {
        exercise.sets.size.toString()
    }

    val countTextStyle = MaterialTheme.typography.labelLarge
    val countTextSize = with(LocalDensity.current) { countTextStyle.fontSize.toDp() }

    ListItemWrapper(
        onClick = onClick,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = exercise.exerciseTemplate.name,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                )
                Text(
                    text = exercise.timestamp.formatTime(),
                    style = MaterialTheme.typography.labelSmall,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Icon(
                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_exercise_24),
                    contentDescription = null,
                    modifier = Modifier.size(countTextSize)
                )
                Text(
                    text = exerciseCount,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun ExercisesScreenPreview() {
    TrainingTrackerTheme {
        ExercisesScreen(
            onAction = {},
            state = ExercisesState(),
            exercises = listOf(),
            navigateToExercise = {},
        )
    }
}