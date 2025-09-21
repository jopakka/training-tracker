package di

import fi.joonasniemi.trainingtracker.feature.workouts.WorkoutsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureWorkoutsModule = module {
    includes(dataModule)
    viewModelOf(::WorkoutsViewModel)
}