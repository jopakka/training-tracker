package fi.joonasniemi.trainingtracker.core.data.workouts.model

import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal fun ExerciseSet.asEntity() = ExerciseSetEntity(
    exerciseSetId = id,
    exerciseId = exerciseId,
)