package ru.sousnein.core.ui.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.sousnein.R
import ru.sousnein.core.ui.utils.noRippleClickable

@Composable
fun BackButton(modifier: Modifier = Modifier, onCLick: () -> Unit) {
    Image(
        modifier = modifier
            .wrapContentSize()
            .noRippleClickable { onCLick.invoke() },
        painter = painterResource(id = R.drawable.ic_back_in_circle),
        contentDescription = null
    )
}