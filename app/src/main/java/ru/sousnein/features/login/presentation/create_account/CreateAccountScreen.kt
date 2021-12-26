package ru.sousnein.features.login.presentation.create_account

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import ru.sousnein.R
import ru.sousnein.core.ui.ContainerView
import ru.sousnein.core.ui.FooterView
import ru.sousnein.core.ui.HeaderView
import ru.sousnein.core.ui.SocialNetworkView
import ru.sousnein.core.ui.buttons.PrimaryButtonView
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputView
import ru.sousnein.features.login.presentation.create_account.models.CreateAccountEvent

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Composable
fun CreateAccountScreen(createAccountViewModel: CreateAccountViewModel) {
    val screenState = createAccountViewModel.currentState.collectAsState().value

    ContainerView {
        HeaderView(
            onCloseIconClick = { createAccountViewModel.obtainEvent(CreateAccountEvent.Exit) },
            titleId = R.string.create_account_title,
            messageId = R.string.create_account_message
        )
        Spacer(modifier = Modifier.height(54.dp))
        ValidationInputView(
            data = screenState.emailState,
            onValueChange = {
                createAccountViewModel.obtainEvent(CreateAccountEvent.ChangeEmail(it))
            }
        )
        Spacer(modifier = Modifier.height(36.dp))
        ValidationInputView(
            data = screenState.passwordState,
            onEndIconClick = {
                createAccountViewModel.obtainEvent(CreateAccountEvent.ShowPassword(it))
            },
            onValueChange = {
                createAccountViewModel.obtainEvent(CreateAccountEvent.ChangePassword(it))
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        ValidationInputView(
            data = screenState.repeatPasswordState,
            onEndIconClick = {
                createAccountViewModel.obtainEvent(CreateAccountEvent.ShowRepeatPassword(it))
            },
            onValueChange = {
                createAccountViewModel.obtainEvent(CreateAccountEvent.ChangeRepeatPassword(it))
            }
        )
    }

    FooterView {
        SocialNetworkView(helperText = R.string.create_account_alternative_account)
        Spacer(modifier = Modifier.height(51.dp))
        PrimaryButtonView(
            modifier = Modifier.fillMaxWidth(),
            isEnabled = screenState.isCreateAccountEnabled,
            onClick = { createAccountViewModel.obtainEvent(CreateAccountEvent.CreateAccount) },
            textId = R.string.global_btn_create_account
        )
    }

}

