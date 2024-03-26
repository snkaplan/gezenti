@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.gezenti.android.library)
    alias(libs.plugins.gezenti.android.library.jacoco)
    kotlin("kapt")
}


android {
    namespace = "com.gezenti.app.core.domain"
}

dependencies {
    implementation(projects.core.data)

    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    api(libs.androidx.compose.runtime)
    //  api(libs.androidx.compose.runtime.livedata)


    implementation(projects.core.common)

    kapt(libs.hilt.compiler)

}