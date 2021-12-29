package ru.sousnein.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.sousnein.core.ui.theme.AndroidClientTheme
import ru.sousnein.core.ui.theme.ColorsConf
import ru.sousnein.features.login.presentation.login.LoadingScreen
import ru.sousnein.main.models.MainActivityState
import ru.sousnein.navigation.AppNavigator
import ru.sousnein.navigation.appNavigation.Navigation
import javax.inject.Inject

@ExperimentalFoundationApi
@ExperimentalUnitApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidClientTheme {
                val state = viewModel.currentState.collectAsState().value
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                systemUiController.setStatusBarColor(ColorsConf.black500)
                systemUiController.setNavigationBarColor(ColorsConf.black500)

                Scaffold {
                    Surface(color = ColorsConf.black500) {
                        when (state) {
                            MainActivityState.Loading -> LoadingScreen()
                            is MainActivityState.Loaded ->
                                Navigation(
                                    navController = navController,
                                    startScreen = state.screens,
                                    modifier = Modifier.padding(bottom = it.calculateBottomPadding()),
                                    appNavigator = appNavigator
                                )
                        }
                        //TODO(сверстать экран вебвью, логику я уже написал, скину в дисе)
                    }
                }


            }
        }
    }

}

