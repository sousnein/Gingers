package ru.sousnein.core.ui.ripple

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import ru.sousnein.core.ui.theme.ColorsConf

object SecondaryButtonRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            ColorsConf.black400,
            lightTheme = false
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            ColorsConf.black500,
            lightTheme = false
        )
}