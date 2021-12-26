package ru.sousnein.features.login.presentation.create_account.domain

import ru.sousnein.R


object GetPasswordEndIconAfterCompareUseCase {

    operator fun invoke(comparePasswordError: Int?) = when (comparePasswordError) {
        null -> R.drawable.ic_check
        else -> R.drawable.ic_eye
    }

}