package fi.joonasniemi.trainingtracker.core.data.workouts.mappers

import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal fun ExerciseSet.asEntity() = ExerciseSetEntity(
    exerciseSetId = id,
    exerciseId = exerciseId,
)