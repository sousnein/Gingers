package ru.sousnein.navigation.models

sealed class NavigationAction {

    object PopUp : NavigationAction()

    data class NewRoot(val route:String ) : NavigationAction()

    data class PopUpTo(val popUpToScreen: PopUpToScreen) : NavigationAction()

    data class Navigate(val navigationTarget: NavigationTarget) : NavigationAction()

}
