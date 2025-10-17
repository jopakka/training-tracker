package di

import fi.joonasniemi.trainingtracker.feature.exersiceselect.ExerciseSelectViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureExerciseSelectModule = module {
    includes(dataModule)

    viewModelOf(::ExerciseSelectViewModel)
}