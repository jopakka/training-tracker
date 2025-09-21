package fi.joonasniemi.trainingtracker.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutWithExercisesAndSets
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutsDao {
    @Transaction
    @Query("SELECT * FROM workouts")
    fun getWorkouts(): Flow<List<WorkoutWithExercisesAndSets>>

    @Transaction
    @Query("SELECT * FROM workouts WHERE workoutId = :workoutId")
    fun getWorkout(workoutId: String): Flow<WorkoutWithExercisesAndSets?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(vararg exercises: ExerciseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseSets(vararg exerciseSets: ExerciseSetEntity)
}