package ru.sousnein.core.domain.validation

import ru.sousnein.R

object ValidateEmailUseCase {

    private val emailRegex =
        "[a-zA-Z0-9_]+([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~\\-]*[a-zA-Z0-9])?@([a-zA-Z0-9](-?[a-zA-Z0-9]){0,62}\\.){1,4}[a-zA-Z]{2,}".toRegex()
    private const val invalidError = R.string.global_email_format_error
    private const val existEmail = R.string.global_email_already_exist_error
    private const val emptyEmail = R.string.global_empty_input_error

    operator fun invoke(email: String?, isEmailExist: Boolean): Int? {
        return email?.let { it ->
            when {
                isEmailExist -> existEmail
                !it.matches(emailRegex) -> invalidError
                it.isEmpty()-> emptyEmail
                else -> null
            }
        }
    }

}