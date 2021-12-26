package ru.sousnein.features.login.presentation.login

import androidx.activity.compose.BackHandler
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
import ru.sousnein.core.ui.buttons.SecondaryButtonView
import ru.sousnein.core.ui.edit_texts.validation_input.ValidationInputView
import ru.sousnein.core.ui.theme.Dimens
import ru.sousnein.core.ui.utils.noRippleClickable
import ru.sousnein.features.login.presentation.login.models.LoginEvent

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val screenState = viewModel.currentState.collectAsState().value

    ContainerView {
        HeaderView(
            onCloseIconClick = { viewModel.obtainEvent(LoginEvent.Exit) },
            titleId = R.string.login_title,
            messageId = R.string.login_message
        )
        Spacer(modifier = Modifier.height(54.dp))
        ValidationInputView(
            data = screenState.emailState,
            onValueChange = { viewModel.obtainEvent(LoginEvent.ChangeEmail(it)) }
        )
        Spacer(modifier = Modifier.height(Dimens.dp15))
        ValidationInputView(
            data = screenState.passwordState,
            onEndIconClick = { viewModel.obtainEvent(LoginEvent.ShowPassword(it)) },
            onValueChange = { viewModel.obtainEvent(LoginEvent.ChangePassword(it)) }
        )
    }

    FooterView {
        SocialNetworkView(helperText = R.string.login_alternative_login)
        Spacer(modifier = Modifier.height(51.dp))
        PrimaryButtonView(
            isEnabled = screenState.isLoginEnabled,
            onClick = { viewModel.obtainEvent(LoginEvent.Login) },
            textId = R.string.global_sign_in,
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable { viewModel.obtainEvent(LoginEvent.Login) }
        )
        Spacer(modifier = Modifier.height(Dimens.dp15))
        SecondaryButtonView(
            onClick = { viewModel.obtainEvent(LoginEvent.CreateAccount) },
            textId = R.string.global_btn_create_account
        )
    }

    BackHandler {
        viewModel.obtainEvent(LoginEvent.BackClicked)
    }

}