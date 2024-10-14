plugins {
    alias(libs.plugins.chuumong.android.application)
    alias(libs.plugins.chuumong.android.application.compose)
    alias(libs.plugins.chuumong.hilt)
}

android {
    namespace = "com.chuumong.composetemplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chuumong.composetemplate"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.feature.space)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)

    ksp(libs.hilt.compiler)
}