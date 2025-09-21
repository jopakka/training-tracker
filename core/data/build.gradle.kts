plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.trainingtracker.android.koin)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.core.data"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.model)
}