package di

import fi.joonasniemi.trainingtracker.feature.exercises.ExercisesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureExercisesModule = module {
    includes(dataModule)

    viewModelOf(::ExercisesViewModel)
}