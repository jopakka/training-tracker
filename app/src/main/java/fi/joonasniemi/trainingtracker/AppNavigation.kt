package fi.joonasniemi.trainingtracker

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import fi.joonasniemi.trainingtracker.feature.workout.WorkoutRoute
import fi.joonasniemi.trainingtracker.feature.workouts.WorkoutsRoute
import kotlinx.serialization.Serializable

@Serializable
data object WorkoutsNavigation

fun NavHostController.navigateToWorkouts(navOptions: NavOptions? = null) {
    navigate(WorkoutsNavigation, navOptions)
}

fun NavGraphBuilder.workoutsRoute(
    navigateToWorkout: (String) -> Unit,
) {
    composable<WorkoutsNavigation> {
        WorkoutsRoute(
            navigateToWorkout = navigateToWorkout,
        )
    }
}

@Serializable
data class ActiveWorkoutNavigation(
    val workoutId: String,
)

fun NavHostController.navigateToActiveWorkout(workoutId: String, navOptions: NavOptions? = null) {
    navigate(ActiveWorkoutNavigation(workoutId), navOptions)
}

fun NavGraphBuilder.activeWorkoutRoute() {
    composable<ActiveWorkoutNavigation> {
        WorkoutRoute()
    }
}
