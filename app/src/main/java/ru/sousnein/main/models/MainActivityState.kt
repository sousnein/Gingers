package ru.sousnein.main.models

import ru.sousnein.core.architecture.ViewState
import ru.sousnein.navigation.screens.Screens

sealed class MainActivityState : ViewState {

    data class Loaded(val screens: Screens) : MainActivityState()

    object Loading : MainActivityState()

}

