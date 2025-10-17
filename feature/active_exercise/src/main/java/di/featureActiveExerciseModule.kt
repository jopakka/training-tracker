package di

import fi.joonasniemi.trainingtracker.feature.activeexercise.ActiveExerciseViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureActiveExerciseModule = module {
    includes(dataModule)

    viewModelOf(::ActiveExerciseViewModel)
}