package ru.sousnein.core.ui.ripple

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import ru.sousnein.core.ui.theme.ColorsConf

object PrimaryButtonRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            ColorsConf.navy400,
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            ColorsConf.black500,
            lightTheme = true
        )
}