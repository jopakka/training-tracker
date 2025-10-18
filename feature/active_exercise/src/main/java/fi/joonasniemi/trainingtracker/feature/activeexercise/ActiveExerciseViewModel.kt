package fi.joonasniemi.trainingtracker.feature.activeexercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExercisesRepository
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ActiveExerciseViewModel(
    private val exerciseId: String,
    private val exercisesRepository: ExercisesRepository,
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Napier.e(throwable.message ?: "Unknown error", throwable)
    }

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
            is ActiveExerciseAction.AddNewSet -> onAddNewSet(action.exerciseSet)
            is ActiveExerciseAction.DeleteSet -> onDeleteSet(action.exerciseSet)
            else -> TODO("Action  not yet implemented")
        }
    }

    private fun onAddNewSet(exerciseSet: ExerciseSet) {
        viewModelScope.launch(coroutineExceptionHandler) {
            exercisesRepository.addExerciseSet(exerciseSet.copy(exerciseId = exerciseId))
        }
    }

    private fun onDeleteSet(exerciseSet: ExerciseSet) {
        viewModelScope.launch(coroutineExceptionHandler) {
            exercisesRepository.deleteExerciseSet(exerciseSet)
        }
    }
}