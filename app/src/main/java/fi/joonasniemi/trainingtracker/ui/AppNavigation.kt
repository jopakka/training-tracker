package fi.joonasniemi.trainingtracker.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import fi.joonasniemi.trainingtracker.feature.activeexercise.ActiveExerciseScreen
import fi.joonasniemi.trainingtracker.feature.exercises.ExercisesScreen
import fi.joonasniemi.trainingtracker.feature.exersiceselect.ExerciseSelectScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
data object ExercisesRoute

fun NavGraphBuilder.exercises(
    navigateToExercise: (String) -> Unit,
) {
    composable<ExercisesRoute> {
        ExercisesScreen(
            navigateToExercise = navigateToExercise,
        )
    }
}

@Serializable
data object ExerciseSelectRoute

fun NavHostController.navigateToExerciseSelect(navOptions: NavOptions? = null) {
    navigate(ExerciseSelectRoute, navOptions)
}


fun NavGraphBuilder.exerciseSelect(
    navigateToExercise: (String) -> Unit,
) {
    composable<ExerciseSelectRoute> {
        ExerciseSelectScreen(
            navigateToExercise = navigateToExercise,
        )
    }
}

@Serializable
data class ActiveExerciseRoute(
    val exerciseId: String,
)

fun NavHostController.navigateToActiveExercise(exerciseId: String, navOptions: NavOptions? = null) {
    navigate(ActiveExerciseRoute(exerciseId), navOptions)
}


fun NavGraphBuilder.activeExercise() {
    composable<ActiveExerciseRoute> {
        val route = it.toRoute<ActiveExerciseRoute>()
        ActiveExerciseScreen(
            viewModel = koinViewModel { parametersOf(route.exerciseId) },
        )
    }
}