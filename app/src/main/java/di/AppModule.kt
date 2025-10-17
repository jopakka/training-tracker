package di

import org.koin.dsl.module

val appModule = module {
    includes(featureExercisesModule)
    includes(featureActiveExerciseModule)
    includes(featureExerciseSelectModule)
}