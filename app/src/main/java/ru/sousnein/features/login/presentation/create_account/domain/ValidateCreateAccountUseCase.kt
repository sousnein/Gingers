package ru.sousnein.features.login.presentation.create_account.domain

object ValidateCreateAccountUseCase {

    operator fun invoke(
        emailError: Int?,
        passwordError: Int?,
        repeatPasswordError: Int?,
        email: String
    ) = emailError == null
            && passwordError == null
            && repeatPasswordError == null
            && email.isNotBlank()

}