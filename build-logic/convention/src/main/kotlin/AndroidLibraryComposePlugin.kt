import com.android.build.gradle.LibraryExtension
import com.chuumong.plugin.configureAndroidCompose
import com.chuumong.plugin.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                add("implementation", libs.findLibrary("androidx-compose-ui-geometry-android").get())
                add("implementation", libs.findLibrary("androidx-compose-animation-core-android").get())
            }
        }
    }
}