package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Embedded
import androidx.room.Relation
import fi.joonasniemi.trainingtracker.core.model.Workout

data class WorkoutWithExercises(
    @Embedded val workout: WorkoutEntity,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "workoutId"
    )
    val exercises: List<ExerciseEntity>
)
