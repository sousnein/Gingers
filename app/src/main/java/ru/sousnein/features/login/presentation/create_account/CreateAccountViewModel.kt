package ru.sousnein.features.login.presentation.create_account

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.sousnein.core.architecture.MviViewModel
import ru.sousnein.core.domain.validation.ComparePasswordsUseCase
import ru.sousnein.core.domain.validation.ValidateEmailUseCase
import ru.sousnein.core.domain.validation.ValidatePasswordUseCase
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputViewData
import ru.sousnein.features.login.common.domain.ChangeMaskAndIconColorUseCase
import ru.sousnein.features.login.common.domain.GetPasswordEndIconUseCase
import ru.sousnein.features.login.common.domain.SignUpUseCase
import ru.sousnein.features.login.navigation.ILoginNavigation
import ru.sousnein.features.login.presentation.create_account.domain.*
import ru.sousnein.features.login.presentation.create_account.models.CreateAccountEvent
import ru.sousnein.features.login.presentation.create_account.models.CreateAccountState
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val loginNavigation: ILoginNavigation,
    private val signUpUseCase: SignUpUseCase
) :
    MviViewModel<CreateAccountState, CreateAccountEvent>(CreateAccountState()) {

    override fun obtainEvent(event: CreateAccountEvent) {
        when (event) {
            CreateAccountEvent.CreateAccount -> onCreateAccount()
            is CreateAccountEvent.ChangeEmail -> onChangeEmail(event.state)
            is CreateAccountEvent.ChangePassword -> onChangePassword(event.state)
            is CreateAccountEvent.ChangeRepeatPassword -> onChangeRepeatPassword(event.state)
            is CreateAccountEvent.ShowPassword -> onShowPassword(event.state, true)
            is CreateAccountEvent.ShowRepeatPassword -> onShowPassword(event.state, false)
            CreateAccountEvent.Exit -> loginNavigation.exit()
        }
    }

    private fun onChangeEmail(state: ValidationInputViewData) {
        val emailError = ValidateEmailUseCase.invoke(state.value, false)
        val newState =
            currentState.value.copy(emailState = state.copy(error = emailError))
                .validateCreateAccountButtonState()
        updateState(newState)
    }

    private fun onChangePassword(state: ValidationInputViewData) {
        val passwordError = ValidatePasswordUseCase.invoke(state.value)

        var newState = currentState.value.copy(
            passwordState = state.copy(
                error = passwordError,
                icon = GetPasswordEndIconUseCase.invoke(state.value)
            )
        ).validateCreateAccountButtonState()

        newState = comparePasswordsAndGetNewState(
            passwordError = passwordError,
            passwordState = state,
            repeatPasswordState = currentState.value.repeatPasswordState,
            currentPasswordErrorState = newState,
        )

        updateState(newState)
    }

    private fun onChangeRepeatPassword(state: ValidationInputViewData) {
        val passwordError = ValidatePasswordUseCase.invoke(state.value)

        var newState = currentState.value.copy(
            repeatPasswordState = state.copy(
                error = passwordError,
                icon = GetPasswordEndIconUseCase.invoke(state.value)
            )
        ).validateCreateAccountButtonState()

        newState = comparePasswordsAndGetNewState(
            passwordError = passwordError,
            passwordState = currentState.value.passwordState,
            repeatPasswordState = state,
            currentPasswordErrorState = newState,
        )

        updateState(newState)
    }

    private fun onShowPassword(state: ValidationInputViewData, isPasswordState: Boolean) {
        val maskAndColor = ChangeMaskAndIconColorUseCase.invoke(state.maskType)
        val newState = if (isPasswordState) {
            currentState.value.copy(
                passwordState = state.copy(
                    maskType = maskAndColor.first,
                    iconColor = maskAndColor.second
                )
            )
        } else {
            currentState.value.copy(
                repeatPasswordState = state.copy(
                    maskType = maskAndColor.first,
                    iconColor = maskAndColor.second
                )
            )
        }

        updateState(newState)
    }

    private fun onCreateAccount() {
        viewModelScope.launch {
            val state = currentState.value
            signUpUseCase.invoke(
                email = state.emailState.value,
                password = state.passwordState.value
            )
        }
    }

    private fun comparePasswordsAndGetNewState(
        passwordError: Int?,
        passwordState: ValidationInputViewData,
        repeatPasswordState: ValidationInputViewData,
        currentPasswordErrorState: CreateAccountState,
    ): CreateAccountState {
        return if (passwordError == null) {
            val comparePassError = ComparePasswordsUseCase.invoke(
                firstPass = passwordState.value,
                secondPass = repeatPasswordState.value
            )

            val passEndIcon =
                GetPasswordEndIconAfterCompareUseCase.invoke(comparePasswordError = comparePassError)
            val passEncIconColor = GetPasswordEndIconColorAfterCompareUseCase.invoke(
                comparePasswordError = comparePassError,
                previousColor = passwordState.iconColor
            )
            val repeatPassEncIconColor = GetPasswordEndIconColorAfterCompareUseCase.invoke(
                comparePasswordError = comparePassError,
                previousColor = repeatPasswordState.iconColor
            )
            val passIconClickable =
                GetPasswordEndIconClickableAfterCompare.invoke(compareError = comparePassError)
            val passMaskType = ChangeMaskTypeAfterCompare.invoke(
                compareError = comparePassError,
                previousMaskType = passwordState.maskType
            )
            val repeatPassMaskType = ChangeMaskTypeAfterCompare.invoke(
                compareError = comparePassError,
                previousMaskType = repeatPasswordState.maskType
            )

            currentState.value.copy(
                passwordState = passwordState.copy(
                    error = comparePassError,
                    icon = passEndIcon,
                    iconColor = passEncIconColor,
                    iconClickable = passIconClickable,
                    maskType = passMaskType
                ),
                repeatPasswordState = repeatPasswordState.copy(
                    error = comparePassError,
                    icon = passEndIcon,
                    iconColor = repeatPassEncIconColor,
                    iconClickable = passIconClickable,
                    maskType = repeatPassMaskType
                )
            ).validateCreateAccountButtonState()
        } else currentPasswordErrorState
    }

    private fun CreateAccountState.validateCreateAccountButtonState(): CreateAccountState {
        val isInputCorrect = ValidateCreateAccountUseCase.invoke(
            emailError = emailState.error,
            passwordError = passwordState.error,
            repeatPasswordError = repeatPasswordState.error,
            email = emailState.value
        )
        return this.copy(isCreateAccountEnabled = isInputCorrect)
    }

}