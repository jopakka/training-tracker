package fi.joonasniemi.trainingtracker.feature.exersiceselect

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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

    BackHandler(state.selectedCategory != null) {
        viewModel.onAction(ExerciseSelectAction.SelectCategory(null))
    }

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
            if (state.selectedCategory == null) {
                categoryItems(
                    templates = templates,
                    onClick = {
                        onAction(ExerciseSelectAction.SelectCategory(it.category))
                    },
                )
            } else {
                exerciseTemplateItems(
                    templates = templates,
                    selectedCategory = state.selectedCategory,
                    onClick = {
                        onAction(ExerciseSelectAction.TemplateSelected(it))
                    },
                )
            }
        }
    }
}

private fun LazyListScope.categoryItems(
    onClick: (ExerciseTemplate) -> Unit,
    templates: List<ExerciseTemplate>,
) {
    val categories = templates.distinctBy { it.category }

    items(
        items = categories,
        key = { it.id },
    ) {
        TemplateCategoryItem(
            template = it,
            onClick = { onClick(it) },
        )
    }
}

@Composable
private fun TemplateCategoryItem(
    onClick: () -> Unit,
    template: ExerciseTemplate,
    modifier: Modifier = Modifier,
) {
    ListItemWrapper(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(template.category)
    }
}

private fun LazyListScope.exerciseTemplateItems(
    onClick: (ExerciseTemplate) -> Unit,
    templates: List<ExerciseTemplate>,
    selectedCategory: String,
) {
    val filteredTemplates = templates.filter { it.category == selectedCategory }

    items(
        items = filteredTemplates,
        key = { it.id },
    ) {
        ExerciseTemplateItem(
            template = it,
            onClick = { onClick(it) },
        )
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