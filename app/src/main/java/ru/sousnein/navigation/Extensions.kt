package ru.sousnein.navigation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.currentBackStackEntryAsState

//TODO( баг либы, пока что другого решения нет)
fun Context.popOrExit(navController: NavController) {
    val backStackSize = navController.backQueue.count()
    if (backStackSize > 2) {
        navController.popBackStack()
    } else {
        (this as? Activity)?.finish()
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun rememberNavController(navController: NavHostController): NavHostController {
    val context = LocalContext.current
    return rememberSaveable(saver = navControllerSaver(context)) {
        navController
    }
}

private fun navControllerSaver(
    context: Context
): Saver<NavHostController, *> = Saver<NavHostController, Bundle>(
    save = { it.saveState() },
    restore = { createNavController(context).apply { restoreState(it) } }
)

fun createNavController(context: Context) =
    NavHostController(context).apply {
        navigatorProvider.addNavigator(ComposeNavigator())
    }
