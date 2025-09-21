package di

import org.koin.dsl.module

val appModule = module {
    includes(featureWorkoutsModule)
    includes(featureActiveWorkoutModule)
}