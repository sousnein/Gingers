package ru.sousnein.core.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.sousnein.R
import ru.sousnein.core.ui.ripple.PrimaryButtonRippleTheme
import ru.sousnein.core.ui.theme.*
import ru.sousnein.core.ui.utils.noRippleClickable

@ExperimentalUnitApi
@Composable
fun ButtonWithIcon(modifier: Modifier = Modifier, textId: Int, onClick: () -> Unit) {
    CompositionLocalProvider(LocalRippleTheme provides PrimaryButtonRippleTheme) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(ColorsConf.black400, Rounded.small)
                .noRippleClickable { onClick.invoke() }
                .padding(start = 15.dp, end = Dimens.dp12, top = Dimens.dp12, bottom = Dimens.dp12)
        ) {
            Text(
                text = stringResource(id = textId),
                style = BitTextStyle.body1
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = null,
                tint = ColorsConf.white
            )
        }

    }
}

@ExperimentalUnitApi
@Composable
@Preview
private fun PrimaryButtonView_Preview() {
    AndroidClientTheme {
        ButtonWithIcon(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ },
            textId = R.string.global_empty_input_error
        )
    }
}
