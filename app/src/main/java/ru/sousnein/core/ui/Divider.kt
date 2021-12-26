package ru.sousnein.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sousnein.core.ui.theme.ColorsConf

@Composable
fun Divider(height: Int = 1) {
    Box(
        modifier = Modifier
            .background(ColorsConf.black400)
            .height(height.dp)
            .fillMaxWidth()
    )
}