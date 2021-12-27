package ru.sousnein.features.login.navigation

import ru.sousnein.features.login.di.LoginNavigator
import ru.sousnein.navigation.AppNavigator
import ru.sousnein.navigation.screens.Screens
import javax.inject.Inject

class LoginNavigationImpl @Inject constructor(
    @LoginNavigator private val navigator: AppNavigator,
    private val appNavigator: AppNavigator
) : ILoginNavigation {

    override fun navigateToCreateAccount() {
        navigator.navigate(Screens.CreateAccount.route) {
            this.launchSingleTop = true
        }
    }

    override fun navigateToRestoreNavigator() {
        navigator.navigate(Screens.Recover.route) {
            launchSingleTop = true
        }
    }

    override fun navigateToLogin() {
        navigator.popUpTo(route = Screens.Login.route, isInclusive = false)
    }

    override fun exit() {
        //TODO provide inner navigator
        appNavigator.popOrExit()
    }


}