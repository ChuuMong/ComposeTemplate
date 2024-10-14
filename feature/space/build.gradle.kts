plugins {
    alias(libs.plugins.chuumong.android.feature)
}

android {
    namespace = "com.chuumong.feature.space"
}

dependencies {
    implementation(projects.core.ui)

    implementation(projects.feature.planet)
    implementation(projects.feature.stars)
}