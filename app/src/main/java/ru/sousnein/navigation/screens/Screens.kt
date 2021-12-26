package ru.sousnein.navigation.screens

sealed class Screens(val route: String) {

    object CreateAccount : Screens(route = "create_account")

    object Login : Screens(route = "login")

    object Recover : Screens(route = "recover")

    object WebView : Screens("web_view")

}