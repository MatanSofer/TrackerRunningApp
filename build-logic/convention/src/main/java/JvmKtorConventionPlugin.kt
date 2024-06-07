import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import com.android.build.api.dsl.LibraryExtension
import com.matans.convention.ExtensionType
import com.matans.convention.configureBuildTypes
import com.matans.convention.configureKotlinAndroid
import com.matans.convention.configureKotlinJvm
import com.matans.convention.libs


class JvmKtorConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                "implementation"(libs.findBundle("ktor").get())
            }
        }
    }
}