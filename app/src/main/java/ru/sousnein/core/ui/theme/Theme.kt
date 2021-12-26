package ru.sousnein.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi

private val DarkColorPalette = darkColors(
    primary = ColorsConf.navy500,
    background = ColorsConf.black500,
)

@ExperimentalUnitApi
@Composable
fun AndroidClientTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        content = content,
        typography = BitTextStyle
    )
}