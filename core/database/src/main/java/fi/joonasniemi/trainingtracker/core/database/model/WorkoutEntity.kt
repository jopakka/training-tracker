package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey
    val workoutId: String,
    val timestamp: Instant,
)
