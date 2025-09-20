package fi.joonasniemi.trainingtracker.feature.exercises

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExercisesRoute(
    viewModel: ExercisesViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    
    ExercisesScreen(
        onAction = viewModel::onAction,
        state = state,
    )
}

@Composable
fun ExercisesScreen(
    onAction: (ExercisesAction) -> Unit,
    state: ExercisesState,
) {

}

@Preview
@Composable
private fun ExercisesScreenPreview() {
    TrainingTrackerTheme {
        ExercisesScreen(
            onAction = {},
            state = ExercisesState(),
        )
    }
}