plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.trainingtracker.android.library.compose)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.core.ui"
}

dependencies {
    api(projects.core.designsystem)
}