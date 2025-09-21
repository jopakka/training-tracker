package fi.joonasniemi.trainingtracker.feature.workouts

data class WorkoutsState(
    val loadingWorkouts: Boolean = true,
    val error: String? = null,
    val openedWorkoutId: String? = null,
)
