plugins {
    alias(libs.plugins.trackerrunningapp.android.feature.ui)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.matans.analytics.presentation"
}

dependencies {
  implementation(projects.analytics.domain)
}