package ru.sousnein.navigation.screens

sealed class Screens(val route: String) {

    object Login : Screens(route = "login")

    object Loading : Screens(route = "login")

    object WebView : Screens("web_view")

}