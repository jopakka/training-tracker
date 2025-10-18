package fi.joonasniemi.trainingtracker.core.model

data class ExerciseSet(
    val id: String,
    val exerciseId: String,
    val type: ExerciseSetType,
)
