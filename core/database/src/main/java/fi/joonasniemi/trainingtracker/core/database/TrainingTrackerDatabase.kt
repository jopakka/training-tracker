package fi.joonasniemi.trainingtracker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fi.joonasniemi.trainingtracker.core.database.dao.ExerciseTemplateDao
import fi.joonasniemi.trainingtracker.core.database.dao.ExercisesDao
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseTemplateEntity
import fi.joonasniemi.trainingtracker.core.database.util.ExerciseSetTypeEnumConverter
import fi.joonasniemi.trainingtracker.core.database.util.InstantConverter

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        ExerciseEntity::class,
        ExerciseSetEntity::class,
        ExerciseTemplateEntity::class,
    ],
)
@TypeConverters(
    InstantConverter::class,
    ExerciseSetTypeEnumConverter::class,
)
internal abstract class TrainingTrackerDatabase : RoomDatabase() {
    abstract fun exercisesDao(): ExercisesDao
    abstract fun exerciseTemplateDao(): ExerciseTemplateDao
}