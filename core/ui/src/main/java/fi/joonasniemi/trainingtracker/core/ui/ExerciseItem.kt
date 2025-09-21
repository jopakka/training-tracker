package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.Exercise
import fi.joonasniemi.trainingtracker.core.model.Workout
import kotlinx.datetime.LocalDate
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.char
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Composable
fun ExerciseItem(
    exercise: Exercise,
    onClick: (Exercise) -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItemWrapper(
        onClick = { onClick(exercise) },
        modifier = modifier,
    ) {
        Text(exercise.id)
    }
}

@Preview
@Composable
private fun ExerciseItemPreview() {
    TrainingTrackerTheme {
        TrainingTrackerBackground(
            modifier = Modifier.size(400.dp, 100.dp),
        ) {
            ExerciseItem(
                exercise = Exercise(
                    id = "id",
                    workoutId = "workoutId",
                    sets = listOf(),
                ),
                onClick = {},
            )
        }
    }
}
