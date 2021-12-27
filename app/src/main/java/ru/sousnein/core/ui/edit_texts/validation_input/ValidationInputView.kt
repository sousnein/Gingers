package ru.sousnein.core.ui.edit_texts.validation_input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.sousnein.androidclient.R
import ru.sousnein.core.ui.edit_texts.MaskType
import ru.sousnein.core.ui.edit_texts.basic_input.BasicInputView
import ru.sousnein.core.ui.errors.TextErrorView
import ru.sousnein.core.ui.theme.AndroidClientTheme
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.theme.Dimens
import ru.sousnein.core.ui.theme.Rounded

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Composable
fun ValidationInputView(
    modifier: Modifier = Modifier,
    data: ValidationInputViewData,
    onValueChange: (ValidationInputViewData) -> Unit = {},
    onEndIconClick: (ValidationInputViewData) -> Unit = {}
) {
    var text by rememberSaveable { mutableStateOf(data.value) }

    val inputTextColor = if (data.error != null) ColorsConf.error600 else ColorsConf.white
    val mask = when (data.maskType) {
        MaskType.NONE -> VisualTransformation.None
        MaskType.PASSWORD -> PasswordVisualTransformation(mask = '*')
    }

    Column(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        BasicInputView(
            value = text,
            mask = mask,
            inputTextColor = inputTextColor,
            onValueChange = { newText ->
                text = newText
                onValueChange.invoke(data.copy(value = newText))
            },
            decoration = { input ->
                input()
                ValidationDecorationView(data, text, onEndIconClick)
            },
            backgroundPadding = Dimens.dp15,
            modifier = Modifier
                .background(shape = Rounded.small, color = ColorsConf.black400)
                .fillMaxWidth()
        )

        data.error?.let { error ->
            Spacer(modifier = Modifier.height(6.dp))
            TextErrorView(error)
        }

    }

}

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
private fun ValidationInput_Preview() {
    AndroidClientTheme(darkTheme = true) {
        ValidationInputView(
            modifier = Modifier.fillMaxWidth(1f),
            data = ValidationInputViewData(hint = R.string.global_open_email)
        )
    }
}