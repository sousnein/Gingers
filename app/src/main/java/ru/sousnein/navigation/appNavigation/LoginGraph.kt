package ru.sousnein.navigation.appNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import ru.sousnein.features.login.presentation.create_account.CreateAccountScreen
import ru.sousnein.features.login.presentation.create_account.CreateAccountViewModel
import ru.sousnein.features.login.presentation.login.LoginScreen
import ru.sousnein.features.login.presentation.login.LoginViewModel
import ru.sousnein.navigation.AppNavigator
import ru.sousnein.navigation.NavContainer
import ru.sousnein.navigation.screens.Screens

@ExperimentalUnitApi
@ExperimentalComposeUiApi
@Composable
fun LoginGraph(localNavigator: AppNavigator) {
    NavContainer(
        localNavigator = localNavigator,
        startDestination = Screens.Login.route,
        screens = listOf(
            Pair(Screens.Login.route, {
                val viewModel = hiltViewModel<LoginViewModel>()
                LoginScreen(viewModel = viewModel)
            }),
            Pair(Screens.CreateAccount.route, {
                val viewModel = hiltViewModel<CreateAccountViewModel>()
                CreateAccountScreen(createAccountViewModel = viewModel)
            })
        )
    )
}