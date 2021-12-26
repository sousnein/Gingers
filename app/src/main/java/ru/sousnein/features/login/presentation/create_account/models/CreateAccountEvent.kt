package ru.sousnein.features.login.presentation.create_account.models

import ru.sousnein.core.architecture.ViewEvent
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputViewData

sealed class CreateAccountEvent : ViewEvent {

    data class ChangeEmail(val state: ValidationInputViewData) : CreateAccountEvent()

    data class ChangePassword(val state: ValidationInputViewData) : CreateAccountEvent()

    data class ChangeRepeatPassword(val state: ValidationInputViewData) : CreateAccountEvent()

    data class ShowPassword(val state: ValidationInputViewData) : CreateAccountEvent()

    data class ShowRepeatPassword(val state: ValidationInputViewData) : CreateAccountEvent()

    object CreateAccount : CreateAccountEvent()

    object Exit : CreateAccountEvent()

}