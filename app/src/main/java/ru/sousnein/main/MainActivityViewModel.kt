package ru.sousnein.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.sousnein.core.architecture.MviViewModel
import ru.sousnein.core.architecture.ViewEvent
import ru.sousnein.main.models.MainActivityState
import ru.sousnein.navigation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : MviViewModel<MainActivityState, ViewEvent>(
    MainActivityState.Loading
) {

    init {
        viewModelScope.launch {
            delay(2000)
            updateState(MainActivityState.Loaded(Screens.Login))
        }

    }

    override fun obtainEvent(event: ViewEvent) {}

}