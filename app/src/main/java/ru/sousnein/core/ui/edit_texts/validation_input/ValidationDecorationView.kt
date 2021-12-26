package ru.sousnein.core.ui.edit_texts.validation_input

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import ru.sousnein.core.ui.theme.BitTextStyle
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.utils.noRippleClickable

@ExperimentalUnitApi
@Composable
fun ValidationDecorationView(
    data: ValidationInputViewData,
    text: String,
    onEndIconClick: (ValidationInputViewData) -> Unit
) {
    Box {

        if (data.hint != null && text.isEmpty()) {
            Text(
                text = stringResource(id = data.hint),
                style = BitTextStyle.body1,
                color = ColorsConf.black100,
            )
        }

        if (data.icon != null) {
            Icon(
                painter = painterResource(id = data.icon),
                tint = data.iconColor,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd).run {
                    if (data.iconClickable) noRippleClickable { onEndIconClick.invoke(data) } else this
                }
            )
        }

    }
}