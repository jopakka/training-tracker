package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet

@Entity(tableName = "exercise_sets")
data class ExerciseSetEntity(
    @PrimaryKey
    val exerciseSetId: String,
    val exerciseId: String,
)

fun ExerciseSetEntity.asExternalModel() = ExerciseSet(
    id = exerciseSetId,
    exerciseId = exerciseId,
)