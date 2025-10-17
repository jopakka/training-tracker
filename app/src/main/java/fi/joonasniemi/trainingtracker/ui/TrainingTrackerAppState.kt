package fi.joonasniemi.trainingtracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberTrainingTrackerAppState(
    navController: NavHostController = rememberNavController(),
): TrainingTrackerAppState {
    return remember(navController) {
        TrainingTrackerAppState(
            navController = navController,
        )
    }
}

@Stable
class TrainingTrackerAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)
            return currentEntry.value?.destination
        }

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = TopLevelDestination.entries.firstOrNull { destination ->
            currentDestination?.hasRoute(destination.route) == true
        }
}