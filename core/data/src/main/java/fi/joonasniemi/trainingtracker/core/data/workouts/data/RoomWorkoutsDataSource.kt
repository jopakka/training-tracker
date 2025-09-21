package fi.joonasniemi.trainingtracker.core.data.workouts.data

import fi.joonasniemi.trainingtracker.core.database.dao.WorkoutsDao
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutWithExercisesAndSets
import kotlinx.coroutines.flow.Flow

internal class RoomWorkoutsDataSource(
    private val workoutsDao: WorkoutsDao,
) {
    val workouts = workoutsDao.getWorkouts()

    fun getWorkout(workoutId: String): Flow<WorkoutWithExercisesAndSets?> {
        return workoutsDao.getWorkout(workoutId)
    }

    suspend fun insertWorkout(workout: WorkoutEntity) {
        return workoutsDao.insertWorkout(workout)
    }
    
    suspend fun insertExercises(vararg exercise: ExerciseEntity) {
        return workoutsDao.insertExercises(*exercise)
    }
    
    suspend fun insertExerciseSets(vararg exerciseSet: ExerciseSetEntity) {
        return workoutsDao.insertExerciseSets(*exerciseSet)
    }
}