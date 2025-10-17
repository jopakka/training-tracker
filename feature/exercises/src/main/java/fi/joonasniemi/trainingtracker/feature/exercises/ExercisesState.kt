package fi.joonasniemi.trainingtracker.feature.exercises

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class ExercisesState(
    val exercisesFrom: Instant = Clock.System.now(),
    val exercisesTo: Instant = Clock.System.now(),
)
