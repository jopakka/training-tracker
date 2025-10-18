package fi.joonasniemi.trainingtracker.core.model

data class ExerciseTemplate(
    val id: String,
    val name: String,
    val category: String,
    val type: ExerciseSetTypeEnum,
) {
    companion object {
        val Preview = ExerciseTemplate(
            id = "id",
            name = "name",
            category = "category",
            type = ExerciseSetTypeEnum.WEIGHT_AND_REPS,
        )
    }
}
