package fi.joonasniemi.trainingtracker.core.data.workouts.mappers

import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.model.Exercise
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal fun Exercise.asEntity() = ExerciseEntity(
    exerciseId = id,
    exerciseTemplateId = exerciseTemplate.id,
    timestamp = timestamp.toEpochMilliseconds(),
)