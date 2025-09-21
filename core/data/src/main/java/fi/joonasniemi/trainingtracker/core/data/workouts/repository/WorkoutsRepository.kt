package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutsRepository {
    val workouts: Flow<List<Workout>>

    fun getWorkout(workoutId: String): Flow<Workout?>

    suspend fun addWorkout(workout: Workout)

    suspend fun addExercise(exercise: Exercise)

    suspend fun addExerciseSet(set: ExerciseSet)
}