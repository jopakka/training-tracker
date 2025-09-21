package fi.joonasniemi.trainingtracker.feature.workout

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.Workout
import fi.joonasniemi.trainingtracker.core.ui.ExerciseItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutRoute(
    viewModel: ActiveWorkoutViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val workout by viewModel.workout.collectAsStateWithLifecycle()

    WorkoutScreen(
        onAction = viewModel::onAction,
        state = state,
        workout = workout,
        onClick = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    onAction: (ActiveWorkoutAction) -> Unit,
    onClick: (Exercise) -> Unit,
    state: ActiveWorkoutState,
    workout: Workout?,
) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn {
            if (workout == null) {
                item { CircularProgressIndicator() }
                return@LazyColumn
            }

            if (state.error != null) {
                item { Text(state.error) }
                return@LazyColumn
            }

            items(workout.exercises) {
                ExerciseItem(exercise = it, onClick = onClick)
            }
        }
    }
}

@Preview
@Composable
private fun WorkoutScreenPreview() {
    TrainingTrackerTheme {
        WorkoutScreen(
            onAction = {},
            state = ActiveWorkoutState(),
            workout = null,
            onClick = {},
        )
    }
}