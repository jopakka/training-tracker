package fi.joonasniemi.trainingtracker.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseTemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseTemplateDao {
    @Query("SELECT * FROM exercise_templates")
    fun getExerciseTemplatesFlow(): Flow<List<ExerciseTemplateEntity>>

    @Query("SELECT * FROM exercise_templates")
    suspend fun getExerciseTemplates(): List<ExerciseTemplateEntity>

    @Upsert
    suspend fun upsertExerciseTemplates(vararg exerciseTemplate: ExerciseTemplateEntity)
}