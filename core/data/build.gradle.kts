plugins {
    alias(libs.plugins.trackerrunningapp.android.library)
    alias(libs.plugins.trackerrunningapp.jvm.ktor)
}

android {
    namespace = "com.matans.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}