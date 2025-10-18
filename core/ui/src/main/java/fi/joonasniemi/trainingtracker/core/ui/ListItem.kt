package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.joonasniemi.trainingtracker.core.designsystem.components.TrainingTrackerBackground
import fi.joonasniemi.trainingtracker.core.designsystem.theme.TrainingTrackerTheme

@Composable
fun ListItemWrapper(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ListItemWrapperDefaults.shape,
    content: @Composable BoxScope.() -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .defaultMinSize(minHeight = 48.dp)
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
            )
            .background(MaterialTheme.colorScheme.surface, shape)
            .border(1.dp, MaterialTheme.colorScheme.outline, shape)
            .clip(shape)
            .indication(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
            )
            .padding(8.dp)
            .fillMaxWidth(),
        content = content,
        contentAlignment = Alignment.Center,
    )
}

object ListItemWrapperDefaults {
    val shape: Shape
        @Composable
        get() = MaterialTheme.shapes.medium
}

@Preview(widthDp = 400, heightDp = 100)
@Composable
private fun ListItemPreview() {
    TrainingTrackerTheme {
        Box {
            ListItemWrapper(
                onClick = {},
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Title")
                    Text("Subtitle")
                }
            }
        }
    }
}