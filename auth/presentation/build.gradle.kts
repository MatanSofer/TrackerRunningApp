plugins {
    alias(libs.plugins.trackerrunningapp.android.feature.ui)
}

android {
    namespace = "com.matans.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)

}