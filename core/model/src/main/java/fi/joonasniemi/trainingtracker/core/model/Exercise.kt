package fi.joonasniemi.trainingtracker.core.model

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class Exercise(
    val id: String,
    val workoutId: String,
    val exerciseTemplate: ExerciseTemplate,
    val sets: List<ExerciseSet>,
    val timestamp: Instant,
)
