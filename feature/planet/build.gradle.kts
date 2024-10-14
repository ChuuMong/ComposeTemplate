plugins {
    alias(libs.plugins.chuumong.android.feature)
}

android {
    namespace = "com.chuumong.feature.planet"
}

dependencies {
    implementation(projects.core.ui)
}