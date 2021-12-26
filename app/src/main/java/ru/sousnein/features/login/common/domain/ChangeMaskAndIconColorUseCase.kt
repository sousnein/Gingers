package ru.sousnein.features.login.common.domain

import androidx.compose.ui.graphics.Color
import ru.sousnein.core.ui.edit_texts.MaskType
import ru.sousnein.core.ui.theme.ColorsConf

object ChangeMaskAndIconColorUseCase {

    operator fun invoke(currentMask: MaskType): Pair<MaskType, Color> {
        val iconColor: Color
        val changedMask = if (currentMask == MaskType.NONE) {
            iconColor = ColorsConf.white
            MaskType.PASSWORD
        } else {
            iconColor = ColorsConf.navy500
            MaskType.NONE
        }
        return Pair(changedMask, iconColor)
    }

}