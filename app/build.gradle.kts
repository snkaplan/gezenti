@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.gezenti.android.application)
    alias(libs.plugins.gezenti.android.application.compose)
    alias(libs.plugins.gezenti.android.application.flavors)
    alias(libs.plugins.gezenti.android.application.jacoco)
    alias(libs.plugins.gezenti.android.hilt)
    id("jacoco")
    id("gezenti.android.room")
    id("gezenti.kotlinter")
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        applicationId = "com.gezenti.app"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    namespace = "com.gezenti.app"
}
dependencies {
    implementation(projects.feature.login)
    implementation(projects.feature.home)

    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.ui)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.coil.kt)
    implementation(libs.compose.state.events)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.navigation.testing)
    debugImplementation(libs.square.leakcanary)

    kapt(libs.square.moshi.kotlin.codegen)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    // Core functions
    kaptTest(libs.hilt.compiler)
    testImplementation(kotlin("test"))
    testImplementation(libs.androidx.navigation.testing)

}