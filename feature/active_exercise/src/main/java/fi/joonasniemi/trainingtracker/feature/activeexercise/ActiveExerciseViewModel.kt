package fi.joonasniemi.trainingtracker.feature.activeexercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExercisesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ActiveExerciseViewModel(
    private val exerciseId: String,
    private val exercisesRepository: ExercisesRepository,
) : ViewModel() {
    private var _hasInitialDataLoaded = false

    private val _state = MutableStateFlow(ActiveExerciseState())
    val state: StateFlow<ActiveExerciseState> = _state
        .onStart {
            if (!_hasInitialDataLoaded) {
                /** Load initial data here */
                _hasInitialDataLoaded = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ActiveExerciseState()
        )

    val exercise = exercisesRepository.getExercise(exerciseId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    fun onAction(action: ActiveExerciseAction) {
        when (action) {
            else -> TODO("Action  not yet implemented")
        }
    }
}