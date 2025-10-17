package fi.joonasniemi.trainingtracker.feature.exersiceselect

import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

sealed interface ExerciseSelectAction {
    data class TemplateSelected(val template: ExerciseTemplate) : ExerciseSelectAction
}