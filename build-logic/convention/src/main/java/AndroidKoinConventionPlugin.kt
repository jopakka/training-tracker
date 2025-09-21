import com.android.build.api.dsl.ApplicationExtension
import fi.joonasniemi.trainingtracker.buildlogic.convention.configureAndroidCompose
import fi.joonasniemi.trainingtracker.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findLibrary("koin-android").get())
                add("implementation", libs.findLibrary("koin-android-compose").get())
                add("testImplementation", libs.findLibrary("koin-test-junit4").get())
            }
        }
    }
}