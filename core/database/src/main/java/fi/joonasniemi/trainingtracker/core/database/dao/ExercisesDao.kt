package fi.joonasniemi.trainingtracker.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseWithSets
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisesDao {
    @Transaction
    @Query("SELECT * FROM exercises WHERE timestamp BETWEEN :from AND :to ORDER BY timestamp DESC")
    fun listExercises(from: Long, to: Long): Flow<List<ExerciseWithSets>>

    @Transaction
    @Query("SELECT * FROM exercises WHERE exerciseId = :exerciseId")
    fun getExercise(exerciseId: String): Flow<ExerciseWithSets?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSet(exerciseSet: ExerciseSetEntity)
}