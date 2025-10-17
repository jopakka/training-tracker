package fi.joonasniemi.trainingtracker.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fi.joonasniemi.trainingtracker.feature.exercises.ExercisesScreen
import kotlinx.serialization.Serializable

@Serializable
data object ExercisesRoute

fun NavGraphBuilder.exercises() {
    composable<ExercisesRoute> {
        ExercisesScreen()
    }
}