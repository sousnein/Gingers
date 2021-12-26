package ru.sousnein.features.login.presentation.create_account.domain

import androidx.compose.ui.graphics.Color
import ru.sousnein.core.ui.theme.ColorsConf

object GetPasswordEndIconColorAfterCompareUseCase {

    operator fun invoke(comparePasswordError: Int?, previousColor: Color) = when (comparePasswordError) {
        null -> ColorsConf.navy500
        else -> previousColor
    }

}