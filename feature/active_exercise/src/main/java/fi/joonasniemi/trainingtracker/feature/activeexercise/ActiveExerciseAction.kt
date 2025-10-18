package fi.joonasniemi.trainingtracker.feature.activeexercise

import fi.joonasniemi.trainingtracker.core.model.ExerciseSet

sealed interface ActiveExerciseAction {
    data class AddNewSet(val exerciseSet: ExerciseSet) : ActiveExerciseAction
    data class DeleteSet(val exerciseSet: ExerciseSet) : ActiveExerciseAction
}