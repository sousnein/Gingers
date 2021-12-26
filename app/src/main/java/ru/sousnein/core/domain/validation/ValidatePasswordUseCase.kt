package ru.sousnein.core.domain.validation

import ru.bitreader.androidclient.R

object ValidatePasswordUseCase {

    private const val emptyPassError = R.string.global_empty_input_error
    private const val shortPassError = R.string.global_short_passwords_error
    private const val MIN_PASSWORD_LENGTH = 8

    operator fun invoke(password: String) = when {
        password.isEmpty() -> emptyPassError
        password.length < MIN_PASSWORD_LENGTH -> shortPassError
        else -> null
    }

}