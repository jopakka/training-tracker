package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Composable
fun Instant.formatTime(): String {
    return remember {
        toLocalDateTime(TimeZone.currentSystemDefault()).format(dateTimeFormat)
    }
}

private val dateTimeFormat = LocalDateTime.Format {
    hour(Padding.NONE); char(':'); minute()
}