package fi.joonasniemi.trainingtracker.feature.exersiceselect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExerciseTemplateRepository
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExercisesRepository
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class, ExperimentalTime::class)
class ExerciseSelectViewModel(
    exerciseTemplatesRepository: ExerciseTemplateRepository,
    private val exercisesRepository: ExercisesRepository,
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Napier.e("ExerciseSelectViewModel exception", throwable)
    }

    private val _exerciseCreatedChannel = Channel<String>()
    val exerciseCreated = _exerciseCreatedChannel.receiveAsFlow()

    private var _hasInitialDataLoaded = false

    private val _state = MutableStateFlow(ExerciseSelectState())
    val state: StateFlow<ExerciseSelectState> = _state
        .onStart {
            if (!_hasInitialDataLoaded) {
                /** Load initial data here */
                _hasInitialDataLoaded = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ExerciseSelectState()
        )

    val templates = exerciseTemplatesRepository.exerciseTemplates
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun onAction(action: ExerciseSelectAction) {
        when (action) {
            is ExerciseSelectAction.TemplateSelected -> onCreateExercise(action.template)
            is ExerciseSelectAction.SelectCategory -> selectCategory(action.categoryId)
            else -> TODO("Action  not yet implemented")
        }
    }

    private fun selectCategory(category: String?) {
        _state.update { it.copy(selectedCategory = category) }
    }

    private fun onCreateExercise(template: ExerciseTemplate) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val id = Uuid.random().toString()
            exercisesRepository.addExercise(
                Exercise(
                    id = id,
                    exerciseTemplate = template,
                    timestamp = Clock.System.now(),
                    sets = emptyList(),
                )
            )

            _exerciseCreatedChannel.send(id)
        }
    }
}