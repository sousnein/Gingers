package ru.sousnein.features.login.presentation.login.models

import ru.sousnein.R
import ru.sousnein.core.architecture.ViewState
import ru.sousnein.core.ui.edit_texts.MaskType
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputViewData

data class LoginState(
    val isLoading: Boolean = false,
    val emailState: ValidationInputViewData = ValidationInputViewData(hint = R.string.global_email),
    val passwordState: ValidationInputViewData = ValidationInputViewData(
        hint = R.string.global_password,
        maskType = MaskType.PASSWORD
    ),
    val isLoginEnabled: Boolean = false,
) : ViewState
