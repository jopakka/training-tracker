package fi.joonasniemi.trainingtracker.feature.exercises

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.ui.ListItemWrapper
import org.koin.androidx.compose.koinViewModel
import kotlin.time.ExperimentalTime

@Composable
fun ExercisesScreen(
    viewModel: ExercisesViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val exercises by viewModel.exercises.collectAsStateWithLifecycle()

    ExercisesScreen(
        onAction = viewModel::onAction,
        state = state,
        exercises = exercises,
    )
}

@Composable
internal fun ExercisesScreen(
    onAction: (ExercisesAction) -> Unit,
    state: ExercisesState,
    exercises: List<Exercise>,
) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn {
            items(
                items = exercises,
                key = { it.id },
            ) {
                ExerciseItem(
                    exercise = it,
                    onClick = {},
                )
            }
        }
    }
}

@Composable
private fun ExerciseItem(
    exercise: Exercise,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItemWrapper(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(exercise.exerciseTemplate.name)
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
        )
    }
}