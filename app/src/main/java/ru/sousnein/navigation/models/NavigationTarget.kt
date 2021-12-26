package ru.sousnein.navigation.models

import androidx.navigation.NavOptions

data class NavigationTarget(
        val route: String,
        val navOptions: NavOptions
    )