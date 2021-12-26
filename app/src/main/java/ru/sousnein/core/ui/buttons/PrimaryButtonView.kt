package ru.sousnein.core.ui.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.bitreader.androidclient.R
import ru.sousnein.core.ui.ripple.PrimaryButtonRippleTheme
import ru.sousnein.core.ui.theme.AndroidClientTheme
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.theme.Rounded
import ru.sousnein.core.ui.theme.TextSize

@ExperimentalUnitApi
@Composable
fun PrimaryButtonView(modifier: Modifier = Modifier, onClick: () -> Unit, textId: Int, isEnabled: Boolean = true) {
    CompositionLocalProvider(LocalRippleTheme provides PrimaryButtonRippleTheme) {
        TextButton(
            onClick = { onClick.invoke() },
            modifier = modifier.height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorsConf.navy500,
                contentColor = ColorsConf.white,
                disabledContentColor = ColorsConf.black200,
                disabledBackgroundColor = ColorsConf.black400,
            ),
            enabled = isEnabled,
            shape = Rounded.small,
            content = {
                Text(
                    text = stringResource(id = textId),
                    fontSize = TextSize.sp15,
                )
            }
        )
    }
}

@ExperimentalUnitApi
@Composable
@Preview
private fun PrimaryButtonView_Preview() {
    AndroidClientTheme {
        PrimaryButtonView(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ },
            textId = R.string.global_empty_input_error
        )
    }
}
