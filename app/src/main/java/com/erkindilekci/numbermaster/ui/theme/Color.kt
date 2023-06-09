package com.erkindilekci.numbermaster.ui.theme

import androidx.compose.ui.graphics.Color

val LightPrimary = Color(0xFF825500)
val LightOnPrimary = Color(0xFFFFFFFF)
val LightSecondary = Color(0xFF6F5B40)
val LightOnSecondary = Color(0xFFFFFFFF)
val LightError = Color(0xFFBA1B1B)
val LightOnError = Color(0xFFFFFFFF)
val LightBackground = Color(0xFFFCFCFC)
val LightOnBackground = Color(0xFF1F1B16)
val LightSurface = Color(0xFFFCFCFC)
val LightOnSurface = Color(0xFF1F1B16)

val DarkPrimary = Color(0xFFFFB945)
val DarkOnPrimary = Color(0xFF452B00)
val DarkSecondary = Color(0xFFDDC3A2)
val DarkOnSecondary = Color(0xFF3E2E16)
val DarkError = Color(0xFFFFB4A9)
val DarkOnError = Color(0xFF680003)
val DarkBackground = Color(0xFF1F1B16)
val DarkOnBackground = Color(0xFFEAE1D9)
val DarkSurface = Color(0xFF1F1B16)
val DarkOnSurface = Color(0xFFEAE1D9)

private const val percent = 40

val Tiles = mapOf(
    0 to 1.alpha(percent),
    2 to 2.alpha(percent),
    4 to 3.alpha(percent),
    8 to 4.alpha(percent),
    16 to 5.alpha(percent),
    32 to 6.alpha(percent),
    64 to 7.alpha(percent),
    128 to 8.alpha(percent),
    256 to 9.alpha(percent),
    512 to 10.alpha(percent),
    1024 to 11.alpha(percent),
    2048 to 14.alpha(percent),
    4096 to 15.alpha(percent),
    8192 to 16.alpha(percent),
)

private fun Int.alpha(percent: Int) = this * (100f / percent / 100f)