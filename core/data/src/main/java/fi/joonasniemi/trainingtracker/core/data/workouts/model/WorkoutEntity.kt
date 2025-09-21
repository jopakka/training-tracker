package fi.joonasniemi.trainingtracker.core.data.workouts.model

import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal fun Workout.asEntity() = WorkoutEntity(
    workoutId = id,
    timestamp = timestamp,
)