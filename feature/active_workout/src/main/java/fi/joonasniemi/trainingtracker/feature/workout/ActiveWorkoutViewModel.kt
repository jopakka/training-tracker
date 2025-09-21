package fi.joonasniemi.trainingtracker.feature.workout

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.WorkoutsRepository
import fi.joonasniemi.trainingtracker.core.model.Exercise
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ActiveWorkoutViewModel(
    savedStateHandle: SavedStateHandle,
    private val workoutsRepository: WorkoutsRepository,
) : ViewModel() {
    private var _hasInitialDataLoaded = false

    private val _state = MutableStateFlow(ActiveWorkoutState())
    val state: StateFlow<ActiveWorkoutState> = _state
        .onStart {
            if (!_hasInitialDataLoaded) {
                /** Load initial data here */
                _hasInitialDataLoaded = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ActiveWorkoutState()
        )

    private val workoutId = savedStateHandle.getStateFlow(
        key = "workoutId",
        initialValue = "",
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    val workout = workoutId.flatMapLatest { workoutId ->
        workoutsRepository.getWorkout(workoutId)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    fun onAction(action: ActiveWorkoutAction) {
        when (action) {
            is ActiveWorkoutAction.AddExercise -> addExercise()
            else -> TODO("Action  not yet implemented")
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    private fun addExercise() {
        _state.update { it.copy(error = null) }

        val workoutId = workoutId.value
        if (workoutId.isBlank()) {
            _state.update { it.copy(error = "Workout id is blank") }
            return
        }

        viewModelScope.launch {
            try {
                workoutsRepository.addExercise(
                    Exercise(
                        id = Uuid.random().toString(),
                        workoutId = workoutId,
                        sets = listOf()
                    )
                )
            } catch (e: Exception) {
                Log.d(TAG, "Failed to add exercise", e)
                _state.update { it.copy(error = "Failed to add exercise") }
            }
        }
    }

    companion object {
        private val TAG = ActiveWorkoutViewModel::class.java.simpleName
    }
}