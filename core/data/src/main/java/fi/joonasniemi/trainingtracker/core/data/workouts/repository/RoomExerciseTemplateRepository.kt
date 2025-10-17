package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import fi.joonasniemi.trainingtracker.core.data.workouts.mappers.asExerciseTemplate
import fi.joonasniemi.trainingtracker.core.data.workouts.mappers.asExerciseTemplateEntity
import fi.joonasniemi.trainingtracker.core.data.workouts.util.ExerciseTemplateSeeder
import fi.joonasniemi.trainingtracker.core.database.dao.ExerciseTemplateDao
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseTemplateEntity
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomExerciseTemplateRepository(
    private val exerciseTemplateDao: ExerciseTemplateDao,
) : ExerciseTemplateRepository {
    override val exerciseTemplates: Flow<List<ExerciseTemplate>> = exerciseTemplateDao.getExerciseTemplatesFlow()
        .map { it.map(ExerciseTemplateEntity::asExerciseTemplate) }

    override suspend fun addExerciseTemplates(vararg exerciseTemplates: ExerciseTemplate) {
        exerciseTemplateDao.upsertExerciseTemplates(
            *exerciseTemplates
                .map(ExerciseTemplate::asExerciseTemplateEntity)
                .toTypedArray()
        )
    }

    override suspend fun prepopulateExerciseTemplates() {
        val allExerciseTemplates = exerciseTemplateDao.getExerciseTemplates()
        if (allExerciseTemplates.isEmpty()) {
            addExerciseTemplates(
                *ExerciseTemplateSeeder.getInitialExerciseTemplates().toTypedArray()
            )
        }
    }
}