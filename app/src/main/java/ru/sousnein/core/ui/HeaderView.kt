package ru.sousnein.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.sousnein.R
import ru.sousnein.core.ui.theme.BitTextStyle
import ru.sousnein.core.ui.theme.Dimens
import ru.sousnein.core.ui.utils.noRippleClickable

@ExperimentalUnitApi
@Composable
fun ColumnScope.HeaderView(onCloseIconClick: () -> Unit, titleId: Int, messageId: Int) {
    Spacer(modifier = Modifier.height(26.dp))
    Image(
        painter = painterResource(id = R.drawable.ic_cross),
        contentDescription = null,
        modifier = Modifier
            .align(Alignment.End)
            .noRippleClickable {
                onCloseIconClick.invoke()
            })
    Spacer(modifier = Modifier.height(Dimens.dp16))
    Text(
        text = stringResource(id = titleId),
        style = BitTextStyle.h1,
    )
    Spacer(modifier = Modifier.height(Dimens.dp16))
    Text(
        text = stringResource(id = messageId),
        style = BitTextStyle.body1
    )

}