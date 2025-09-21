package fi.joonasniemi.trainingtracker.core.model

import kotlin.time.Instant

@OptIn(kotlin.time.ExperimentalTime::class)
data class Workout(
    val id: String,
    val timestamp: Instant,
    val exercises: List<Exercise>
)
