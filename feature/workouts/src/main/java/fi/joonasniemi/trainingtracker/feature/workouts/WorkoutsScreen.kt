package fi.joonasniemi.trainingtracker.feature.workouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.Workout
import fi.joonasniemi.trainingtracker.core.ui.WorkoutItem
import org.koin.androidx.compose.koinViewModel
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Composable
fun WorkoutsRoute(
    navigateToWorkout: (String) -> Unit,
    viewModel: WorkoutsViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val workouts by viewModel.workouts.collectAsStateWithLifecycle()

    LaunchedEffect(state.openedWorkoutId) {
        val openedWorkoutId = state.openedWorkoutId
        if (openedWorkoutId != null) {
            navigateToWorkout(openedWorkoutId)
            viewModel.onAction(WorkoutsAction.ClearOpenedWorkout)
        }
    }

    WorkoutsScreen(
        onAction = viewModel::onAction,
        state = state,
        workouts = workouts,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutsScreen(
    onAction: (WorkoutsAction) -> Unit,
    state: WorkoutsState,
    workouts: List<Workout>,
) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (state.loadingWorkouts) {
                item { CircularProgressIndicator() }
                return@LazyColumn
            }

            items(workouts) {
                WorkoutItem(workout = it, onClick = { onAction(WorkoutsAction.OpenWorkout(it.id)) })
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun WorkoutsScreenPreview() {
    TrainingTrackerTheme {
        TrainingTrackerBackground {
            WorkoutsScreen(
                onAction = {},
                state = WorkoutsState(),
                workouts = listOf(
                    Workout(
                        id = "1",
                        exercises = listOf(
                            Exercise(
                                id = "1",
                                workoutId = "1",
                                sets = emptyList(),
                            ),
                        ),
                        timestamp = Clock.System.now(),
                    ),
                    Workout(
                        id = "2",
                        exercises = listOf(
                            Exercise(
                                id = "1",
                                workoutId = "2",
                                sets = emptyList(),
                            ),
                            Exercise(
                                id = "1",
                                workoutId = "2",
                                sets = emptyList(),
                            ),
                        ),
                        timestamp = Clock.System.now(),
                    ),
                ),
            )
        }
    }
}