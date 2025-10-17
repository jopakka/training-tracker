package fi.joonasniemi.trainingtracker.feature.exercises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExercisesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class, ExperimentalCoroutinesApi::class)
class ExercisesViewModel(
    private val exercisesRepository: ExercisesRepository,
) : ViewModel() {
    private var _hasInitialDataLoaded = false

    private val _state = MutableStateFlow(ExercisesState())
    val state: StateFlow<ExercisesState> = _state
        .onStart {
            if (!_hasInitialDataLoaded) {
                /** Load initial data here */
                _hasInitialDataLoaded = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ExercisesState()
        )

    val exercises = state.map { it.exercisesFrom to it.exercisesTo }
        .distinctUntilChanged()
        .flatMapConcat { exercisesRepository.exercises(it.first, it.second) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun onAction(action: ExercisesAction) {
        when (action) {
            else -> TODO("Action  not yet implemented")
        }
    }
}