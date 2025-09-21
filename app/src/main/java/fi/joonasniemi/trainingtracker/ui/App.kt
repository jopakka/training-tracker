package fi.joonasniemi.trainingtracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import fi.joonasniemi.trainingtracker.WorkoutsNavigation
import fi.joonasniemi.trainingtracker.activeWorkoutRoute
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.navigateToActiveWorkout
import fi.joonasniemi.trainingtracker.workoutsRoute

@Composable
fun App(
    appState: TrainingTrackerAppState,
    modifier: Modifier = Modifier,
) {
    TrainingTrackerBackground(modifier) {
        Scaffold(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent,
            floatingActionButton = {
                if (appState.currentDestination?.hasRoute<WorkoutsNavigation>() == true) {
                    FloatingActionButton(
                        onClick = {},
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null,
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = appState.navController,
                startDestination = WorkoutsNavigation,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                workoutsRoute(
                    navigateToWorkout = { appState.navController.navigateToActiveWorkout(it) }
                )

                activeWorkoutRoute()
            }
        }
    }
}