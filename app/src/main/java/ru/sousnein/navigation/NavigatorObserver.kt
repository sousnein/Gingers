package ru.sousnein.navigation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.sousnein.navigation.models.NavigationAction

@Composable
fun NavigationObserver(appNavigator: AppNavigator, navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect("navigation") {
        applyAction(appNavigator, context, navController)
    }
}

private fun CoroutineScope.applyAction(
    appNavigator: AppNavigator,
    context: Context,
    navController: NavController
) {
    appNavigator.navigationAction.onEach {
        when (it) {
            NavigationAction.PopUp -> context.popOrExit(navController)
            is NavigationAction.PopUpTo -> {
                navController.popBackStack(
                    route = it.popUpToScreen.route,
                    inclusive = it.popUpToScreen.isInclusive
                )
            }
            is NavigationAction.Navigate -> {
                navController.navigate(
                    it.navigationTarget.route,
                    it.navigationTarget.navOptions
                ).also { Log.d("bzz", it.toString()) }
            }
        }
    }.launchIn(this)
}