package ru.sousnein.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi

@ExperimentalUnitApi
val BitTextStyle = Typography(
    h1 = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp30,
    ),
    h2 = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp18,
        fontWeight = FontWeight.Bold
    ),
    h3 = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp15,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp15,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp15,
        fontWeight = FontWeight.SemiBold
    ),
    caption = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp12,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        color = ColorsConf.white,
        fontFamily = FontFamily.SansSerif,
        fontSize = TextSize.sp15,
        fontWeight = FontWeight.Normal,
    ),
)