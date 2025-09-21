package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Embedded
import androidx.room.Relation
import fi.joonasniemi.trainingtracker.core.model.Exercise

data class ExerciseWithSets(
    @Embedded val exercise: ExerciseEntity,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId"
    )
    val sets: List<ExerciseSetEntity>
)

fun ExerciseWithSets.asExternalModel() = Exercise(
    id = exercise.exerciseId,
    workoutId = exercise.workoutId,
    sets = sets.map(ExerciseSetEntity::asExternalModel),
)