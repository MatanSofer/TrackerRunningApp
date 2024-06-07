plugins {
    alias(libs.plugins.trackerrunningapp.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}