package fi.joonasniemi.trainingtracker.feature.workouts

sealed interface WorkoutsAction {
    data class OpenWorkout(val workoutId: String) : WorkoutsAction
    data object ClearOpenedWorkout : WorkoutsAction

    data object AddWorkout : WorkoutsAction
}