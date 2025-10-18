package fi.joonasniemi.trainingtracker.core.model

import kotlinx.serialization.Serializable

enum class ExerciseSetTypeEnum {
    TIME,
    DISTANCE,
    REPS,
    TIME_AND_WEIGHT,
    WEIGHT_AND_REPS,
}

@Serializable
sealed class ExerciseSetType(val type: ExerciseSetTypeEnum) {
    @Serializable
    data class Time(val millis: Long) : ExerciseSetType(ExerciseSetTypeEnum.TIME)

    @Serializable
    data class Distance(val meters: Double) : ExerciseSetType(ExerciseSetTypeEnum.DISTANCE)

    @Serializable
    data class Reps(val reps: Int) : ExerciseSetType(ExerciseSetTypeEnum.REPS)

    @Serializable
    data class TimeAndWeight(val weight: Double, val millis: Long) :
        ExerciseSetType(ExerciseSetTypeEnum.TIME_AND_WEIGHT)

    @Serializable
    data class WeightAndReps(val weight: Double, val reps: Int) :
        ExerciseSetType(ExerciseSetTypeEnum.WEIGHT_AND_REPS)
}