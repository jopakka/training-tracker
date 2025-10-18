package fi.joonasniemi.trainingtracker.core.data.workouts.mappers

import fi.joonasniemi.trainingtracker.core.database.model.ExerciseTemplateEntity
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

internal fun ExerciseTemplate.asExerciseTemplateEntity(): ExerciseTemplateEntity {
    return ExerciseTemplateEntity(
        exerciseTemplateId = id,
        name = name,
        category = category,
        type = type,
    )
}

internal fun ExerciseTemplateEntity.asExerciseTemplate(): ExerciseTemplate {
    return ExerciseTemplate(
        id = exerciseTemplateId,
        name = name,
        category = category,
        type = type,
    )
}