package ru.sousnein.features.login.presentation.login.domain

object ValidateLoginUseCase {

    operator fun invoke(emailError: Int?, passwordError: Int?, email: String) =
        emailError == null && passwordError == null && email.isNotBlank()

}