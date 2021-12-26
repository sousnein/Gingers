package ru.sousnein.core.ui.edit_texts.validation_input

import androidx.compose.ui.graphics.Color
import ru.sousnein.core.ui.edit_texts.MaskType
import ru.sousnein.core.ui.theme.ColorsConf

data class ValidationInputViewData(
    val value: String = "",
    val error: Int? = null,
    val hint: Int? = null,
    val icon: Int? = null,
    val iconColor: Color = ColorsConf.white,
    val iconClickable: Boolean = true,
    val maskType: MaskType = MaskType.NONE
)
