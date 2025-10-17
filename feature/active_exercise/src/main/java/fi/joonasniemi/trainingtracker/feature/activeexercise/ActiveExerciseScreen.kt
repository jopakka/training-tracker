package fi.joonasniemi.trainingtracker.feature.activeexercise

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveExerciseScreen(
    viewModel: ActiveExerciseViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val exercise by viewModel.exercise.collectAsStateWithLifecycle()

    ActiveExerciseScreen(
        onAction = viewModel::onAction,
        state = state,
    )
}

@Composable
internal fun ActiveExerciseScreen(
    onAction: (ActiveExerciseAction) -> Unit,
    state: ActiveExerciseState,
) {
    Box(Modifier.fillMaxSize()) {
        Text("HELLO")
    }
}

@Preview
@Composable
private fun ActiveExerciseScreenPreview() {
    TrainingTrackerTheme {
        ActiveExerciseScreen(
            onAction = {},
            state = ActiveExerciseState(),
        )
    }
}