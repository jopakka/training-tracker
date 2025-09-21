package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Composable
fun WorkoutItem(
    workout: Workout,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val timeZone = LocalTimeZone.current

    val supportIconSize = with(density) { supportTextStyle.fontSize.toDp() }

    val formattedDate = remember(workout.timestamp) {
        val now = Clock.System.now()
        val localDateTime = now.toLocalDateTime(timeZone)
        val workoutLocalDateTime = workout.timestamp.toLocalDateTime(timeZone)
        if (localDateTime.year == workoutLocalDateTime.year) {
            workout.timestamp.format(sameYearFormat)
        } else {
            workout.timestamp.format(differentYearFormat)
        }
    }

    ListItemWrapper(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp),
    ) {
        Row {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_calendar_clock_24),
                    contentDescription = null,
                    modifier = Modifier.size(supportIconSize),
                )
                Text(
                    text = formattedDate,
                    style = supportTextStyle,
                )
            }

            Spacer(Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(fi.joonasniemi.trainingtracker.assets.R.drawable.assets_outline_exercise_24),
                    contentDescription = null,
                    modifier = Modifier.size(supportIconSize),
                )
                Text(
                    text = workout.exercises.size.toString(),
                    style = supportTextStyle,
                )
            }
        }
    }
}

private val supportTextStyle: TextStyle
    @Composable get() = MaterialTheme.typography.labelLarge

private val sameYearFormat = DateTimeComponents.Format {
    day(Padding.NONE); char('.'); monthNumber(Padding.NONE)
    char(' ')
    hour(); char(':'); minute()
}

private val differentYearFormat = DateTimeComponents.Format {
    day(Padding.NONE); char('.'); monthNumber(Padding.NONE); char('.'); year()
    char(' ')
    hour(); char(':'); minute()
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun WorkoutItemPreview() {
    TrainingTrackerTheme {
        TrainingTrackerBackground {
            Column {
                WorkoutItem(
                    workout = Workout(
                        id = "id",
                        timestamp = Instant.fromEpochMilliseconds(1758467905000),
                        exercises = listOf(
                            Exercise(
                                id = "id",
                                workoutId = "id",
                                sets = emptyList(),
                            ),
                            Exercise(
                                id = "id",
                                workoutId = "id",
                                sets = emptyList(),
                            ),
                        ),
                    ),
                    onClick = {},
                )
            }
        }
    }
}