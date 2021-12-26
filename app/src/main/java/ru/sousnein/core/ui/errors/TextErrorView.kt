package ru.sousnein.core.ui.errors

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import ru.sousnein.core.ui.theme.BitTextStyle
import ru.sousnein.core.ui.theme.ColorsConf

@ExperimentalUnitApi
@Composable
fun TextErrorView(error: Int) {
    Text(
        text = stringResource(id = error),
        style = BitTextStyle.caption,
        color = ColorsConf.error600,
    )
}