@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.gezenti.android.library)
    alias(libs.plugins.gezenti.android.library.jacoco)
    alias(libs.plugins.gezenti.android.hilt)
}

android {
    namespace = "com.gezenti.app.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.compose.state.events)
}