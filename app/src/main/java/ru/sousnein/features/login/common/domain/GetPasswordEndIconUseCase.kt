package ru.sousnein.features.login.common.domain

import ru.sousnein.R

object GetPasswordEndIconUseCase {

    operator fun invoke(password: String) = when (password.isNotEmpty()) {
        true -> R.drawable.ic_eye
        false -> null
    }

}