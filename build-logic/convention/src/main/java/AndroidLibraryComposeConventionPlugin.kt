import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import com.android.build.api.dsl.LibraryExtension
import com.example.convention.configureAndroidCompose
import com.matans.convention.ExtensionType
import com.matans.convention.configureBuildTypes
import com.matans.convention.configureKotlinAndroid
import org.gradle.kotlin.dsl.getByType


class AndroidLibraryComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("trackerrunningapp.android.library")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}