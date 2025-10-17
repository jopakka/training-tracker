package fi.joonasniemi.trainingtracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import fi.joonasniemi.trainingtracker.core.designsystem.components.TopAppBar
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    appState: TrainingTrackerAppState,
    modifier: Modifier = Modifier,
) {
    TrainingTrackerBackground(modifier) {
        Scaffold(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        val titleTextId = appState.currentTopLevelDestination?.titleTextId
                        if (titleTextId != null) {
                            Text(text = stringResource(titleTextId))
                        }
                    },
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = appState.navController,
                startDestination = ExercisesRoute,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                exercises()
            }
        }
    }
}