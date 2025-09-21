package di

import fi.joonasniemi.trainingtracker.feature.workout.ActiveWorkoutViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureActiveWorkoutModule = module {
    includes(dataModule)
    viewModelOf(::ActiveWorkoutViewModel)
}