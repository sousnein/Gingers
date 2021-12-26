package ru.sousnein.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavContainer(
    startDestination: String,
    screens: List<Pair<String, @Composable () -> Unit>> = emptyList(),
    localNavigator: AppNavigator? = null
) {
    val controller = rememberNavController()
    localNavigator?.let { NavigationObserver(appNavigator = it, navController = controller) }

    NavHost(navController = controller, startDestination = startDestination) {
        screens.forEach { screen ->
            composable(screen.first) {
                screen.second.invoke()
            }
        }
    }

}