@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.gezenti.android.feature)
    alias(libs.plugins.gezenti.android.library.compose)
    alias(libs.plugins.gezenti.android.library.jacoco)
}

android {
    namespace = "com.gezenti.home"
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.activity.compose)
}
