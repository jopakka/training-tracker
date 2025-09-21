package fi.joonasniemi.trainingtracker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fi.joonasniemi.trainingtracker.core.database.dao.WorkoutsDao
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseEntity
import fi.joonasniemi.trainingtracker.core.database.model.ExerciseSetEntity
import fi.joonasniemi.trainingtracker.core.database.model.WorkoutEntity
import fi.joonasniemi.trainingtracker.core.database.util.InstantConverter

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        WorkoutEntity::class,
        ExerciseEntity::class,
        ExerciseSetEntity::class,
    ],
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class TrainingTrackerDatabase : RoomDatabase() {
    abstract fun workoutsDao(): WorkoutsDao
}