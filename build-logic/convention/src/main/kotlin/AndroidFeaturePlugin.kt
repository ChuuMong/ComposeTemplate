import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidFeaturePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("chuumong.android.library")
                apply("chuumong.android.hilt")
            }
        }
    }
}