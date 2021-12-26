package ru.sousnein.navigation.appNavigation

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dagger.hilt.android.EntryPointAccessors
import ru.sousnein.navigation.AppNavigator
import ru.sousnein.navigation.NavigationObserver
import ru.sousnein.navigation.di.LocalNavigatorProvider
import ru.sousnein.navigation.screens.Screens

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier,
    startScreen: Screens,
    appNavigator: AppNavigator
) {
    val context = LocalContext.current
    NavigationObserver(appNavigator = appNavigator, navController = navController)

    val localNavigatorProvider = remember {
        EntryPointAccessors.fromActivity(
            context as Activity,
            LocalNavigatorProvider::class.java
        )
    }

    NavHost(
        navController = navController,
        startDestination = startScreen.route,
        modifier = modifier
    ) {
        composable(Screens.Login.route) {
            LoginGraph(localNavigator = localNavigatorProvider.loginNavigator())
        }
    }

}

