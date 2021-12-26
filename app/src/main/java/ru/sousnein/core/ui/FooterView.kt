package ru.sousnein.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.sousnein.core.ui.theme.Dimens

@Composable
fun FooterView(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.BottomCenter,
    content: @Composable ColumnScope.() -> Unit
) {

    Box(
        modifier = modifier
            .padding(horizontal = Dimens.dp20)
            .padding(bottom = Dimens.dp24)
            .fillMaxSize()
    ) {
        Column(Modifier.align(contentAlignment)) {
            content()
        }
    }

}