package ru.sousnein.features.login.presentation.create_account.domain

import ru.sousnein.core.ui.edit_texts.MaskType


object ChangeMaskTypeAfterCompare {

    operator fun invoke(compareError: Int?, previousMaskType: MaskType) = when (compareError) {
        null -> MaskType.PASSWORD
        else -> previousMaskType
    }

}