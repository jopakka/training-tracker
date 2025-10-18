package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import kotlinx.coroutines.flow.Flow
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
interface ExercisesRepository {
    fun exercises(from: Instant, to: Instant): Flow<List<Exercise>>

    fun getExercise(exerciseId: String): Flow<Exercise?>

    suspend fun addExercise(exercise: Exercise)

    suspend fun addExerciseSet(set: ExerciseSet)
    suspend fun deleteExerciseSet(set: ExerciseSet)
}