package fi.joonasniemi.trainingtracker.feature.exercises

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExercisesViewModel : ViewModel() {
    private val _state = MutableStateFlow(ExercisesState())
    val state: StateFlow<ExercisesState> = _state.asStateFlow()

    fun onAction(action: ExercisesAction) {
        when (action) {
            else -> TODO("Action  not yet implemented")
        }
    }
}