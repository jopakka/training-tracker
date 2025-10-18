package fi.joonasniemi.trainingtracker.core.data.workouts.mappers

import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.ExerciseSetType
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal fun ExerciseSet.asEntity(): ExerciseSetEntity {
    var weight: Double? = null
    var reps: Int? = null
    var meters: Double? = null
    var time: Long? = null
    val type = type.type

    when (val setType = this.type) {
        is ExerciseSetType.Reps -> {
            reps = setType.reps
        }

        is ExerciseSetType.Distance -> {
            meters = setType.meters
        }

        is ExerciseSetType.Time -> {
            time = setType.millis
        }

        is ExerciseSetType.WeightAndReps -> {
            weight = setType.weight
            reps = setType.reps
        }

        is ExerciseSetType.TimeAndWeight -> {
            weight = setType.weight
            time = setType.millis
        }
    }

    return ExerciseSetEntity(
        exerciseSetId = id,
        exerciseId = exerciseId,
        weight = weight,
        reps = reps,
        meters = meters,
        time = time,
        type = type,
    )
}