package fi.joonasniemi.trainingtracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import fi.joonasniemi.trainingtracker.R
import fi.joonasniemi.trainingtracker.core.designsystem.components.TopAppBar
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalMaterial3Api::class, ExperimentalUuidApi::class)
@Composable
fun App(
    appState: TrainingTrackerAppState,
    modifier: Modifier = Modifier,
) {
    val currentTopLevelDestination = appState.currentTopLevelDestination

    TrainingTrackerBackground(modifier) {
        Scaffold(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        if (currentTopLevelDestination?.titleTextId != null) {
                            Text(text = stringResource(currentTopLevelDestination.titleTextId))
                        }
                    },
                    navigationIcon = {
                        if (currentTopLevelDestination != TopLevelDestination.EXERCISES) {
                            IconButton(
                                onClick = appState.navController::popBackStack,
                            ) {
                                Icon(
                                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_chevron_left_24),
                                    contentDescription = null,
                                )
                            }
                        }
                    },
                )
            },
            floatingActionButton = {
                if (currentTopLevelDestination == TopLevelDestination.EXERCISES) {
                    FloatingActionButton(
                        onClick = appState.navController::navigateToExerciseSelect,
                    ) {
                        Icon(
                            painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_baseline_add_24),
                            contentDescription = null,
                        )
                    }
                }
            },
        ) { innerPadding ->
            NavHost(
                navController = appState.navController,
                startDestination = ExercisesRoute,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                exercises(
                    navigateToExercise = appState.navController::navigateToActiveExercise,
                )

                exerciseSelect(
                    navigateToExercise = {
                        appState.navController.navigateToActiveExercise(
                            exerciseId = it,
                            navOptions = navOptions {
                                popUpTo(ExercisesRoute)
                            }
                        )
                    },
                )

                activeExercise()
            }
        }
    }
}