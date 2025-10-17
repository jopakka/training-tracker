package di

import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExerciseTemplateRepository
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.RoomExerciseTemplateRepository
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.RoomExercisesRepository
import fi.joonasniemi.trainingtracker.core.data.workouts.repository.ExercisesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule)
    singleOf(::RoomExercisesRepository) { bind<ExercisesRepository>() }
    singleOf(::RoomExerciseTemplateRepository) { bind<ExerciseTemplateRepository>() }
}