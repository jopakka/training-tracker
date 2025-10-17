package fi.joonasniemi.trainingtracker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExerciseTemplateRepository
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.ui.App
import fi.joonasniemi.trainingtracker.ui.rememberTrainingTrackerAppState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val exerciseTemplateRepository by inject<ExerciseTemplateRepository>()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("MainActivity", "prepopulateExerciseTemplates: ", throwable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        prepopulateExerciseTemplates()

        setContent {
            val appState = rememberTrainingTrackerAppState()

            TrainingTrackerTheme {
                App(
                    appState = appState,
                )
            }
        }
    }

    private fun prepopulateExerciseTemplates() {
        lifecycleScope.launch(Dispatchers.IO + errorHandler) {
            exerciseTemplateRepository.prepopulateExerciseTemplates()
        }
    }
}
