package fi.joonasniemi.trainingtracker.feature.exersiceselect

import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

sealed interface ExerciseSelectAction {
    data class SelectCategory(val categoryId: String?) : ExerciseSelectAction
    data class TemplateSelected(val template: ExerciseTemplate) : ExerciseSelectAction
}