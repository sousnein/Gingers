package ru.sousnein.core.ui.edit_texts.basic_input

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.core.ui.theme.TextSize
import ru.sousnein.core.ui.utils.noRippleClickable

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Composable
fun BasicInputView(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    backgroundPadding: Dp = 0.dp,
    textSize: TextUnit = TextSize.sp15,
    fontWeight: FontWeight = FontWeight.Normal,
    mask: VisualTransformation = VisualTransformation.None,
    inputTextColor: Color = ColorsConf.white,
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    focusRequester: FocusRequester = FocusRequester(),
    maxLines: Int = 1,
    decoration: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
) {
    var text by rememberSaveable { mutableStateOf(value) }

    BasicTextField(
        value = text,
        visualTransformation = mask,
        onValueChange = { newText ->
            text = newText
            onValueChange.invoke(newText)
        },
        textStyle = TextStyle(
            color = inputTextColor,
            fontSize = textSize,
            fontFamily = FontFamily.SansSerif,
            fontWeight = fontWeight
        ),
        maxLines = maxLines,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        modifier = modifier
            .focusRequester(focusRequester)
            .noRippleClickable {
                focusRequester.requestFocus()
                keyboardController?.show()
            }
            .padding(backgroundPadding),
        cursorBrush = SolidColor(ColorsConf.black100),
        decorationBox = decoration
    )

}