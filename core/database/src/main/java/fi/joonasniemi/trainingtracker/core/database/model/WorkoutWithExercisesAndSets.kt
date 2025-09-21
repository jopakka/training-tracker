package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Embedded
import androidx.room.Relation
import fi.joonasniemi.trainingtracker.core.model.Workout

data class WorkoutWithExercisesAndSets(
    @Embedded val workout: WorkoutEntity,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "workoutId",
        entity = ExerciseEntity::class,
    )
    val exercises: List<ExerciseWithSets>
)

fun WorkoutWithExercisesAndSets.asExternalModel() = Workout(
    id = workout.workoutId,
    timestamp = workout.timestamp,
    exercises = exercises.map(ExerciseWithSets::asExternalModel),
)