package ru.sousnein.features.login.presentation.login

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.sousnein.core.architecture.MviViewModel
import ru.sousnein.core.domain.validation.ValidateEmailUseCase
import ru.sousnein.core.domain.validation.ValidatePasswordUseCase
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputViewData
import ru.sousnein.features.login.common.domain.ChangeMaskAndIconColorUseCase
import ru.sousnein.features.login.common.domain.GetPasswordEndIconUseCase
import ru.sousnein.features.login.common.domain.SignInUseCase
import ru.sousnein.features.login.navigation.ILoginNavigation
import ru.sousnein.features.login.presentation.login.domain.ValidateLoginUseCase
import ru.sousnein.features.login.presentation.login.models.LoginEvent
import ru.sousnein.features.login.presentation.login.models.LoginState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginNavigation: ILoginNavigation,
    private val signInUseCase: SignInUseCase
) : MviViewModel<LoginState, LoginEvent>(LoginState()) {

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.Login -> onLogin()
            is LoginEvent.ChangeEmail -> onChangeEmail(event.state)
            is LoginEvent.ChangePassword -> onChangePassword(event.state)
            is LoginEvent.ShowPassword -> onShowPassword(event.state)
            LoginEvent.Exit -> loginNavigation.exit()
            LoginEvent.BackClicked -> loginNavigation.exit()
        }
    }

    private fun onChangeEmail(state: ValidationInputViewData) {
        val emailError = ValidateEmailUseCase.invoke(state.value, false)
        val newState =
            currentState.value.copy(emailState = state.copy(error = emailError))
                .validateLoginBtnState()
        updateState(newState)
    }

    private fun onChangePassword(state: ValidationInputViewData) {
        val passwordError = ValidatePasswordUseCase.invoke(state.value)

        val newState = currentState.value.copy(
            passwordState = state.copy(
                error = passwordError,
                icon = GetPasswordEndIconUseCase.invoke(state.value)
            )
        ).validateLoginBtnState()

        updateState(newState)
    }

    private fun onLogin() {
        viewModelScope.launch {
            val state = currentState.value
            val email = state.emailState.value
            val password = state.passwordState.value
            signInUseCase.invoke(email = email, password = password)
        }
    }

    private fun onShowPassword(state: ValidationInputViewData) {
        val maskAndColor = ChangeMaskAndIconColorUseCase.invoke(state.maskType)
        val newState = currentState.value.copy(
            passwordState = state.copy(
                maskType = maskAndColor.first,
                iconColor = maskAndColor.second
            )
        )

        updateState(newState)
    }

    private fun LoginState.validateLoginBtnState(): LoginState {
        val isInputCorrect = ValidateLoginUseCase.invoke(
            emailError = emailState.error,
            passwordError = passwordState.error,
            email = emailState.value
        )
        return this.copy(isLoginEnabled = isInputCorrect)
    }

}