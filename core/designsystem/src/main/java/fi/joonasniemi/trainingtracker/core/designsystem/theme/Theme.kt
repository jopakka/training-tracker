package fi.joonasniemi.trainingtracker.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val TealDarkColorScheme = darkColorScheme(
    primary = TealPrimary,
    onPrimary = DarkTextOnPrimary,
    primaryContainer = MutedGoldAccent,
    onPrimaryContainer = DarkBackground,
    secondary = MutedGoldAccent,
    onSecondary = DarkBackground,
    background = DarkBackground,
    onBackground = DarkSlateText,
    surface = DarkSurface,
    onSurface = DarkSlateText,
    surfaceVariant = DarkSurface,
    onSurfaceVariant = MutedText, // For labels and placeholder text
    error = SoftRedError,
    onError = DarkTextOnPrimary
)

private val TealLightColorScheme = lightColorScheme(
    primary = TealPrimaryLight,
    onPrimary = WhiteTextOnPrimary,
    primaryContainer = GoldAccentLight,
    onPrimaryContainer = WhiteSurface,
    secondary = GoldAccentLight,
    onSecondary = WhiteSurface,
    background = OffWhiteBackground,
    onBackground = NearBlackText,
    surface = WhiteSurface,
    onSurface = NearBlackText,
    surfaceVariant = OffWhiteBackground,
    onSurfaceVariant = GreyText,
    error = RedErrorLight,
    onError = WhiteTextOnPrimary
)

@Composable
fun TrainingTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> TealDarkColorScheme
        else -> TealLightColorScheme
    }

    // Background theme
    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.background,
        tonalElevation = 2.dp,
    )

    CompositionLocalProvider(
        LocalBackgroundTheme provides defaultBackgroundTheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}