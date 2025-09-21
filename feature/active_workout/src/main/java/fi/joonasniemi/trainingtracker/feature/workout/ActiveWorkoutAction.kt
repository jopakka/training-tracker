package fi.joonasniemi.trainingtracker.feature.workout

sealed interface ActiveWorkoutAction {
    data object AddExercise : ActiveWorkoutAction
}