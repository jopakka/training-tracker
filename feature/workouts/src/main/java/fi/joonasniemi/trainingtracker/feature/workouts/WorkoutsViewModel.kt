package fi.joonasniemi.trainingtracker.feature.workouts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.WorkoutsRepository
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class WorkoutsViewModel(
    private val workoutsRepository: WorkoutsRepository,
) : ViewModel() {
    private var _hasInitialDataLoaded = false

    private val _state = MutableStateFlow(WorkoutsState())
    val state: StateFlow<WorkoutsState> = _state
        .onStart {
            if (!_hasInitialDataLoaded) {
                /** Load initial data here */
                _hasInitialDataLoaded = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = WorkoutsState()
        )

    val workouts = workoutsRepository.workouts
        .onEach {
            _state.update { it.copy(loadingWorkouts = false) }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun onAction(action: WorkoutsAction) {
        when (action) {
            is WorkoutsAction.AddWorkout -> addWorkout()
            is WorkoutsAction.OpenWorkout -> setOpenWorkout(action.workoutId)
            is WorkoutsAction.ClearOpenedWorkout -> setOpenWorkout(null)
            else -> TODO("Action  not yet implemented")
        }
    }

    @OptIn(ExperimentalUuidApi::class, ExperimentalTime::class)
    private fun addWorkout() {
        _state.update { it.copy(error = null) }
        viewModelScope.launch {
            val workoutId = Uuid.random().toString()
            try {
                workoutsRepository.addWorkout(
                    Workout(
                        id = workoutId,
                        timestamp = Clock.System.now(),
                        exercises = listOf()
                    )
                )
                setOpenWorkout(workoutId)
            } catch (e: Exception) {
                Log.d(TAG, "Failed to add workout", e)
                _state.update { it.copy(error = "Failed to add workout") }
            }
        }
    }

    private fun setOpenWorkout(workoutId: String?) {
        _state.update { it.copy(openedWorkoutId = workoutId) }
    }

    companion object {
        private val TAG = WorkoutsViewModel::class.java.simpleName
    }
}