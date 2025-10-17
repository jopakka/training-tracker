package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey
    val exerciseId: String,
    val exerciseTemplateId: String,
    val timestamp: Long,
)
