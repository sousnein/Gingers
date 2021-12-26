package ru.sousnein.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.bitreader.androidclient.R
import ru.sousnein.core.ui.theme.BitTextStyle
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.theme.Dimens
import ru.sousnein.core.ui.theme.Rounded

@ExperimentalUnitApi
@Composable
fun Source(title: String) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .background(color = ColorsConf.black300, shape = Rounded.medium)
            .padding(start = Dimens.dp12, end = Dimens.dp12, top = 3.dp, bottom = 3.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = title, style = BitTextStyle.h3)
    }
}