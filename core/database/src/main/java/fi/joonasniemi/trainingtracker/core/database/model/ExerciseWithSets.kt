package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Embedded
import androidx.room.Relation
import fi.joonasniemi.trainingtracker.core.model.Exercise
import kotlin.time.Instant

data class ExerciseWithSets(
    @Embedded val exercise: ExerciseEntity,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId"
    )
    val sets: List<ExerciseSetEntity>,
    @Relation(
        parentColumn = "exerciseTemplateId",
        entityColumn = "exerciseTemplateId"
    )
    val exerciseTemplate: ExerciseTemplateEntity,
)

fun ExerciseWithSets.asExternalModel() = Exercise(
    id = exercise.exerciseId,
    workoutId = exercise.workoutId,
    sets = sets.map(ExerciseSetEntity::asExternalModel),
    exerciseTemplate = exerciseTemplate.asExternalModel(),
    timestamp = Instant.fromEpochMilliseconds(exercise.timestamp),
)