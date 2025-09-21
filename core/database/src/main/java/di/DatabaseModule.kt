package di

import androidx.room.Room
import fi.joonasniemi.trainingtracker.core.database.TrainingTrackerDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TrainingTrackerDatabase::class.java,
            "training_tracker_database"
        ).build()
    }

    includes(daosModule)
}