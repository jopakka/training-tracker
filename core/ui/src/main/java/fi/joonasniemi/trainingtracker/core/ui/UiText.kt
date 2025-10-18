package fi.joonasniemi.trainingtracker.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import fi.joonasniemi.trainingtracker.core.model.UiText
import fi.joonasniemi.trainingtracker.core.model.asString

@Composable
fun UiText.asString(): String {
    val context = LocalContext.current
    return remember { this.asString(context) }
}