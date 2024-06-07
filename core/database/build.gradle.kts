plugins {
    alias(libs.plugins.trackerrunningapp.android.library)
    alias(libs.plugins.trackerrunningapp.android.room)
}

android {
    namespace = "com.matans.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)


    implementation(projects.core.domain)
}