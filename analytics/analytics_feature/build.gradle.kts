plugins {
    alias(libs.plugins.trackerrunningapp.android.dynamic.feature)
}
android {
    namespace = "com.matans.analytics.analytics_feature"

}

dependencies {
    implementation(project(":app"))
    implementation(libs.androidx.navigation.compose)


    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)


}