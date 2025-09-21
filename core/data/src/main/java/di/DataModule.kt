package di

import fi.joonasniemi.trainingtracker.core.data.workouts.data.RoomWorkoutsDataSource
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.RoomWorkoutsRepository
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.WorkoutsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule)
    singleOf(::RoomWorkoutsDataSource)
    singleOf(::RoomWorkoutsRepository) { bind<WorkoutsRepository>() }
}