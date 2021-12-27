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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.sousnein.R
import ru.sousnein.core.ui.ripple.SecondaryButtonRippleTheme
import ru.sousnein.core.ui.theme.AndroidClientTheme
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.theme.Rounded
import ru.sousnein.core.ui.theme.TextSize

@ExperimentalUnitApi
@Composable
fun SecondaryButtonView(
    modifier: Modifier = Modifier,
    textId: Int,
    isEnabled: Boolean = true,
    contentColor: Color = ColorsConf.white,
    onClick: () -> Unit
) {

    CompositionLocalProvider(LocalRippleTheme provides SecondaryButtonRippleTheme) {
        TextButton(
            onClick = { onClick.invoke() },
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = contentColor,
                disabledContentColor = ColorsConf.black200,
                disabledBackgroundColor = Color.Transparent,
            ),
            enabled = isEnabled,
            shape = Rounded.small,
            content = {
                Text(
                    text = stringResource(id = textId),
                    fontSize = TextSize.sp15,
                    color = contentColor
                )
            }
        )
    }
}

@ExperimentalUnitApi
@Composable
@Preview
private fun SecondaryButtonView_Preview() {
    AndroidClientTheme {
        SecondaryButtonView(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ },
            textId = R.string.global_empty_input_error
        )
    }
}