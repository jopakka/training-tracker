import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.trainingtracker.android.library)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.trainingtracker.android.koin)
}

android {
    namespace = "fi.joonasniemi.trainingtracker.core.database"

    room {
        schemaDirectory("$projectDir/schemas")
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.add("-Xopt-in=kotlin.time.ExperimentalTime")
        }
    }
}

dependencies {
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.kotlinx.datetime)

    implementation(projects.core.model)
}