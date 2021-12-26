package ru.sousnein.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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

@ExperimentalUnitApi
@Composable
fun ColumnScope.SocialNetworkView(helperText: Int) {
    Text(
        text = stringResource(id = helperText),
        style = BitTextStyle.body1,
        modifier = Modifier
            .wrapContentHeight()
            .align(Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.height(21.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(21.dp, Alignment.CenterHorizontally),
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(horizontal = Dimens.dp16)
    ) {
        Image(painterResource(id = R.drawable.ic_google), contentDescription = null)
        Image(painterResource(id = R.drawable.ic_vk), contentDescription = null)
        Image(painterResource(id = R.drawable.ic_twitter), contentDescription = null)
    }

}