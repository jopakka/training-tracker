import com.android.build.api.dsl.ApplicationExtension
import fi.joonasniemi.trainingtracker.buildlogic.convention.configureKotlinAndroid
import fi.joonasniemi.trainingtracker.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 36
            }

            dependencies {
                add("implementation", libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }
}