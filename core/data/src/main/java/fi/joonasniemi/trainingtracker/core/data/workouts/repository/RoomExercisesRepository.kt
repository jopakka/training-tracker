package fi.joonasniemi.trainingtracker.core.data.workouts.repository

import fi.joonasniemi.trainingtracker.core.data.workouts.mappers.asEntity
import fi.joonasniemi.trainingtracker.core.database.dao.ExercisesDao
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseWithSets
import fi.joonasniemi.trainingtracker.core.database.model.asExternalModel
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.ExerciseSet
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
internal class RoomExercisesRepository(
    private val exercisesDao: ExercisesDao,
) : ExercisesRepository {
    override fun exercises(
        from: Instant,
        to: Instant
    ): Flow<List<Exercise>> {
        return exercisesDao
            .listExercises(from.toEpochMilliseconds(), to.toEpochMilliseconds())
            .map { exercises ->
                exercises.map(ExerciseWithSets::asExternalModel)
            }
    }

    override fun getExercise(exerciseId: String): Flow<Exercise?> {
        return exercisesDao.getExercise(exerciseId).map { it?.asExternalModel() }
    }

    override suspend fun addExercise(exercise: Exercise): Unit = coroutineScope {
        exercisesDao.insertExercise(exercise.asEntity())
        exercise.sets.map { set ->
            async { addExerciseSet(set) }
        }.awaitAll()
    }

    override suspend fun addExerciseSet(set: ExerciseSet) {
        exercisesDao.insertExerciseSet(set.asEntity())
    }

    override suspend fun deleteExerciseSet(set: ExerciseSet) {
        exercisesDao.deleteExerciseSet(set.asEntity())
    }
}