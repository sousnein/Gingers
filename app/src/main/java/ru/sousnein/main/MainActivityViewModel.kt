package ru.sousnein.main

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sousnein.core.architecture.MviViewModel
import ru.sousnein.core.architecture.ViewEvent
import ru.sousnein.main.models.MainActivityState
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : MviViewModel<MainActivityState, ViewEvent>(
    MainActivityState()
) {

    override fun obtainEvent(event: ViewEvent) {}

}