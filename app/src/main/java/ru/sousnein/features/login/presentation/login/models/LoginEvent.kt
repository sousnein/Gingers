package ru.sousnein.features.login.presentation.login.models

import ru.sousnein.core.architecture.ViewEvent
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputViewData

sealed class LoginEvent : ViewEvent {

    data class ChangeEmail(val state: ValidationInputViewData) : LoginEvent()

    data class ChangePassword(val state: ValidationInputViewData) : LoginEvent()

    data class ShowPassword(val state: ValidationInputViewData) : LoginEvent()

    object Login : LoginEvent()

    object CreateAccount : LoginEvent()

    object Exit : LoginEvent()

    object BackClicked : LoginEvent()

}