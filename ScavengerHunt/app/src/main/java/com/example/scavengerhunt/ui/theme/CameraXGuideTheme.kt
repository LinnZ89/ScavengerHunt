package com.example.scavengerhunt.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


// Define a basic color scheme for the app
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EA),  // Purple 700
    onPrimary = Color.White,
    primaryContainer = Color(0xFF3700B3),  // Purple 900
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF03DAC5),  // Teal 200
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF018786),  // Teal 700
    onSecondaryContainer = Color.White,
    error = Color(0xFFB00020),  // Red 700
    onError = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)
val Shapes = androidx.compose.material3.Shapes()

@Composable
fun CameraXGuideTheme(
    content: @Composable () -> Unit
) {
    // Apply the theme with the color scheme, typography, and shapes
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,  // Use the imported Typography
        shapes = Shapes,          // Use the imported Shapes
        content = content
    )
}