plugins {
    alias(libs.plugins.trackerrunningapp.android.library)
    alias(libs.plugins.trackerrunningapp.jvm.ktor)

}

android {
    namespace = "com.matans.auth.data"
}

dependencies {
    // Koin
    implementation(libs.bundles.koin)
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}