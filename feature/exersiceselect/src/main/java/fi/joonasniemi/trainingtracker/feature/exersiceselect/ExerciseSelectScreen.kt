package fi.joonasniemi.trainingtracker.feature.exersiceselect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme
import fi.joonasniemi.trainingtracker.core.model.ExerciseTemplate
import fi.joonasniemi.trainingtracker.core.ui.ListItemWrapper
import fi.joonasniemi.trainingtracker.core.ui.ObserveAsEvents
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExerciseSelectScreen(
    navigateToExercise: (String) -> Unit,
    viewModel: ExerciseSelectViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val templates by viewModel.templates.collectAsStateWithLifecycle()

    ObserveAsEvents(viewModel.exerciseCreated) {
        navigateToExercise(it)
    }

    ExerciseSelectScreen(
        onAction = viewModel::onAction,
        state = state,
        templates = templates,
    )
}

@Composable
internal fun ExerciseSelectScreen(
    onAction: (ExerciseSelectAction) -> Unit,
    state: ExerciseSelectState,
    templates: List<ExerciseTemplate>,
) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = templates,
                key = { it.id },
            ) {
                ExerciseTemplateItem(
                    template = it,
                    onClick = { onAction(ExerciseSelectAction.TemplateSelected(it)) },
                )
            }
        }
    }
}

@Composable
private fun ExerciseTemplateItem(
    onClick: () -> Unit,
    template: ExerciseTemplate,
    modifier: Modifier = Modifier,
) {
    ListItemWrapper(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(template.name)
    }
}

@Preview
@Composable
private fun ExerciseSelectScreenPreview() {
    TrainingTrackerTheme {
        ExerciseSelectScreen(
            onAction = {},
            state = ExerciseSelectState(),
            templates = listOf(),
        )
    }
}