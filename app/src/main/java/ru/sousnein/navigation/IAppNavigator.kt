package ru.sousnein.navigation

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.sousnein.navigation.models.NavigationAction
import ru.sousnein.navigation.models.NavigationTarget
import ru.sousnein.navigation.models.PopUpToScreen

abstract class IAppNavigator {
    private val _navigationAction = MutableSharedFlow<NavigationAction>(extraBufferCapacity = 1)
    val navigationAction =_navigationAction.asSharedFlow()

    fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit = {}) {
        _navigationAction.tryEmit(
            NavigationAction.Navigate(
                NavigationTarget(
                    route = route,
                    navOptions = navOptions(builder)
                )
            )
        )
    }

    fun popUpTo(route: String, isInclusive: Boolean) {
        _navigationAction.tryEmit(
            NavigationAction.PopUpTo(
                PopUpToScreen(
                    route = route,
                    isInclusive = isInclusive
                )
            )
        )
    }

    fun popOrExit() {
        _navigationAction.tryEmit(NavigationAction.PopUp)
    }

}