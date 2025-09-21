package di

import fi.joonasniemi.trainingtracker.core.database.TrainingTrackerDatabase
import org.koin.dsl.module

internal val daosModule = module {
    factory { get<TrainingTrackerDatabase>().workoutsDao() }
}