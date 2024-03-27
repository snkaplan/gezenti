package com.gezenti.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = Color(0xFF19A7CE),
    onPrimary = Color(0xFF222222),
    primaryContainer = Color(0xFFF0F1F1), // Başlık ve vurgulu öğelerin arka plan rengi
    onPrimaryContainer = Color(0xFFDDDDDD), // Başlık ve vurgulu öğelerin arka plan üzerindeki metin rengi
    secondary = Color(0xFF5296DE), // İkincil öğeler için renk
    onSecondary = Color(0xFF3B3B3B), // İkincil öğeler üzerindeki metin rengi
    secondaryContainer = Color(0xFFF6F1F1), // İkincil öğelerin arka plan rengi
    surface = Color.White, // Yüzey rengi
    surfaceVariant = Color(0xFFFAFAFA), // Yüzey üzerindeki varyasyon rengi
    onSurfaceVariant = Color.Black, // Yüzey üzerindeki varyasyon metin rengi
    background = Color(0xFFF6F1F1), // Ana arka plan rengi
    tertiary = Color(0xFF146C94),
    outlineVariant = Color(0xFF888888), // Ana hat varyasyon rengi
)

private val lightColorScheme = lightColorScheme(
    primary = Color(0xFF19A7CE),
    onPrimary = Color(0xFF222222),
    primaryContainer = Color(0xFFF0F1F1), // Başlık ve vurgulu öğelerin arka plan rengi
    onPrimaryContainer = Color(0xFFDDDDDD), // Başlık ve vurgulu öğelerin arka plan üzerindeki metin rengi
    secondary = Color(0xFFFAFAFA), // İkincil öğeler için renk
    onSecondary = Color(0xFF3B3B3B), // İkincil öğeler üzerindeki metin rengi
    secondaryContainer = Color(0xFFF6F1F1), // İkincil öğelerin arka plan rengi
    surface = Color.White, // Yüzey rengi
    surfaceVariant = Color(0xFFFAFAFA), // Yüzey üzerindeki varyasyon rengi
    onSurfaceVariant = Color.Black, // Yüzey üzerindeki varyasyon metin rengi
    background = Color(0xFFF6F1F1), // Ana arka plan rengi
    tertiary = Color(0xFF146C94),
    outlineVariant = Color(0xFF888888), // Ana hat varyasyon rengi
)

@Composable
fun GezentiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}