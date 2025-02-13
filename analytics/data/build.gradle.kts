plugins {
    alias(libs.plugins.trackerrunningapp.android.library)
    alias(libs.plugins.trackerrunningapp.android.room)
}

android {
    namespace = "com.matans.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)


    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)

}