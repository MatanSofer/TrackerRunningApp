plugins {
    alias(libs.plugins.trackerrunningapp.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(projects.core.domain)
}