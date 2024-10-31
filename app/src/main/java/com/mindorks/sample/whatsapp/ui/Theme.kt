package com.mindorks.sample.whatsapp.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = primaryWhatsAppColor,
    secondary = primaryWhatsAppColor
)

private val LightColorPalette = lightColorScheme(
    primary = primaryWhatsAppColor,
    secondary = primaryWhatsAppColor
)

@Composable
fun WhatsAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        typography = typography,
        shapes = shapes,
        content = content
    )
}