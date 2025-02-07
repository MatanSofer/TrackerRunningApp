plugins {
    alias(libs.plugins.trackerrunningapp.android.library)

}

android {
    namespace = "com.matans.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)

}