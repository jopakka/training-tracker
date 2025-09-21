package fi.joonasniemi.trainingtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.ui.App
import fi.joonasniemi.trainingtracker.ui.rememberTrainingTrackerAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberTrainingTrackerAppState()

            TrainingTrackerTheme {
                App(
                    appState = appState,
                )
            }
        }
    }
}
