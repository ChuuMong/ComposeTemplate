import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "chuumong.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "chuumong.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidFeature") {
            id = "chuumong.android.feature"
            implementationClass = "AndroidFeaturePlugin"
        }
        register("androidApplicationCompose") {
            id = "chuumong.android.application.compose"
            implementationClass = "AndroidApplicationComposePlugin"
        }
        register("androidLibraryCompose") {
            id = "chuumong.android.library.compose"
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("androidHilt") {
            id = "chuumong.android.hilt"
            implementationClass = "AndroidHiltPlugin"
        }
    }
}