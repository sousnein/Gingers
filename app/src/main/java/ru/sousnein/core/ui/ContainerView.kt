package ru.sousnein.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import ru.sousnein.core.ui.theme.Dimens

@Composable
fun ContainerView(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = Dimens.dp20,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxSize()
    ) {
        content()
    }

}