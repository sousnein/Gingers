package ru.sousnein.core.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<State : ViewState, Event : ViewEvent>(initialState: State) : ViewModel() {

    private val _state = MutableStateFlow<State>(initialState)
    internal val currentState = _state.asStateFlow()

    abstract fun obtainEvent(event: Event)

    protected fun updateState(state: State) {
        viewModelScope.launch {
            _state.emit(state)
        }
    }

}