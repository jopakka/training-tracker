package fi.joonasniemi.trainingtracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate

@Entity(tableName = "exercise_templates")
data class ExerciseTemplateEntity(
    @PrimaryKey
    val exerciseTemplateId: String,
    val name: String,
    val category: String,
)

fun ExerciseTemplateEntity.asExternalModel(): ExerciseTemplate {
    return ExerciseTemplate(
        id = exerciseTemplateId,
        name = name,
        category = category,
    )
}
