package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme

@Composable
fun ListItemWrapper(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.medium)
            .clip(MaterialTheme.shapes.medium)
            .indication(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
            )
            .padding(8.dp),
        content = content,
    )
}

@Preview
@Composable
private fun ListItemWrapperPreview() {
    TrainingTrackerTheme {
        TrainingTrackerBackground(
            modifier = Modifier.size(400.dp, 150.dp)
        ) {
            Box(Modifier.background(Color.Red)) {
                ListItemWrapper(
                    onClick = {},
                ) {
                    Column {
                        Text("Title")
                        Text("Subtitle")
                    }
                }
            }
        }
    }
}