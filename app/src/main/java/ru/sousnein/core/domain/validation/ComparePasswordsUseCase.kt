package ru.sousnein.core.domain.validation

import ru.sousnein.androidclient.R

object ComparePasswordsUseCase {

    private const val differentPassError = R.string.global_different_passwords_error

    operator fun invoke(firstPass: String, secondPass: String) = when {
        firstPass != secondPass -> differentPassError
        else -> null
    }
}