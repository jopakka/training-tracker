package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetType
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetTypeEnum

@Entity(tableName = "exercise_sets")
data class ExerciseSetEntity(
    @PrimaryKey
    val exerciseSetId: String,
    val exerciseId: String,
    val type: ExerciseSetTypeEnum,
    val weight: Double? = null,
    val reps: Int? = null,
    val meters: Double? = null,
    val time: Long? = null
)

fun ExerciseSetEntity.asExternalModel(): ExerciseSet {
    val type = when(type) {
        ExerciseSetTypeEnum.TIME -> ExerciseSetType.Time(
            millis = time ?: throw IllegalArgumentException("Time cannot be null for TIME"),
        )
        ExerciseSetTypeEnum.REPS -> ExerciseSetType.Reps(
            reps = reps ?: throw IllegalArgumentException("Reps cannot be null for REPS"),
        )
        ExerciseSetTypeEnum.DISTANCE -> ExerciseSetType.Distance(
            meters = meters ?: throw IllegalArgumentException("Distance cannot be null for DISTANCE"),
        )
        ExerciseSetTypeEnum.WEIGHT_AND_REPS -> ExerciseSetType.WeightAndReps(
            weight = weight ?: throw IllegalArgumentException("Weight cannot be null for WEIGHT_AND_REPS"),
            reps = reps ?: throw IllegalArgumentException("Reps cannot be null for WEIGHT_AND_REPS"),
        )
        ExerciseSetTypeEnum.TIME_AND_WEIGHT -> ExerciseSetType.TimeAndWeight(
            weight = weight ?: throw IllegalArgumentException("Weight cannot be null for TIME_AND_WEIGHT"),
            millis = time ?: throw IllegalArgumentException("Time cannot be null for TIME_AND_WEIGHT"),
        )
    }
    return ExerciseSet(
        id = exerciseSetId,
        exerciseId = exerciseId,
        type = type,
    )
}