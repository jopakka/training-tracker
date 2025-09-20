plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.trainingtracker.android.library.compose)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material3)
}