package fi.joonasniemi.trainingtracker.core.model

data class Exercise(
    val id: String,
    val workoutId: String,
    val sets: List<ExerciseSet>
)
