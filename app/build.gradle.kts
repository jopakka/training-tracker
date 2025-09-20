plugins {
    alias(libs.plugins.trainingtracker.android.application)
    alias(libs.plugins.trainingtracker.android.application.compose)
    alias(libs.plugins.trainingtracker.android.koin)
}

android {
    namespace = "fi.joonasniemi.trainingtracker"

    defaultConfig {
        applicationId = "fi.joonasniemi.trainingtracker"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(projects.core.ui)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    testImplementation(libs.kotlin.test)

    androidTestImplementation(libs.kotlin.test)
}