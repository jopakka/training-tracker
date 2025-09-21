package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import android.util.Log
import fi.joonasniemi.trainingtracker.core.data.workouts.data.RoomWorkoutsDataSource
import fi.joonasniemi.trainingtracker.core.data.workouts.model.asEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutWithExercisesAndSets
import fi.joonasniemi.trainingtracker.core.database.model.asExternalModel
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

internal class RoomWorkoutsRepository(
    private val dataSource: RoomWorkoutsDataSource,
) : WorkoutsRepository {
    override val workouts = dataSource.workouts.map { workouts ->
        workouts.map(WorkoutWithExercisesAndSets::asExternalModel)
    }.catch {
        Log.d(TAG, "Failed to get workouts", it)
        emit(emptyList())
    }

    override fun getWorkout(workoutId: String): Flow<Workout?> {
        return dataSource.getWorkout(workoutId).map {
            it?.asExternalModel()
        }
    }

    override suspend fun addWorkout(workout: Workout): Unit = coroutineScope {
        val deferred = mutableListOf<Deferred<*>>()

        deferred.add(async { dataSource.insertWorkout(workout.asEntity()) })
        workout.exercises.forEach {
            deferred.add(async { addExercise(it) })
        }

        deferred.awaitAll()
    }

    override suspend fun addExercise(exercise: Exercise): Unit = coroutineScope {
        val deferred = mutableListOf<Deferred<*>>()

        deferred.add(async { dataSource.insertExercises(exercise.asEntity()) })
        exercise.sets.forEach { set ->
            deferred.add(async { addExerciseSet(set) })
        }

        deferred.awaitAll()
    }

    override suspend fun addExerciseSet(set: ExerciseSet) {
        dataSource.insertExerciseSets(set.asEntity())
    }

    companion object {
        private val TAG = RoomWorkoutsRepository::class.java.simpleName
    }
}