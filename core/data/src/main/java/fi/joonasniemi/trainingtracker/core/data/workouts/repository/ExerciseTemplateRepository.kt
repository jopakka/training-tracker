package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate
import kotlinx.coroutines.flow.Flow

interface ExerciseTemplateRepository {
    val exerciseTemplates: Flow<List<ExerciseTemplate>>

    suspend fun addExerciseTemplates(vararg exerciseTemplates: ExerciseTemplate)

    suspend fun prepopulateExerciseTemplates()
}