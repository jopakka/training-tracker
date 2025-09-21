plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.trainingtracker.android.library.compose)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.core.ui"
}

dependencies {
    implementation(projects.assets)
    api(projects.core.designsystem)
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)
}