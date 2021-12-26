package ru.sousnein.main.models

import ru.sousnein.core.architecture.ViewState
import ru.sousnein.navigation.screens.Screens

data class MainActivityState(
    val startScreen: Screens = Screens.CreateAccount
) : ViewState
