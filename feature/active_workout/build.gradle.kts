plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.trainingtracker.android.library.compose)
    alias(libs.plugins.trainingtracker.android.feature)
    alias(libs.plugins.trainingtracker.android.koin)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.feature.workout"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.ui)
}