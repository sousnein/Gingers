package ru.sousnein.core.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun ViewModel.safeLaunch(errorHandler: (Throwable) -> Unit = {}, action: () -> Unit): Job = viewModelScope.launch {
    try {
        action.invoke()
    } catch (e: Throwable) {
        errorHandler.invoke(e)
    }
}

fun ViewModel.safeScope(errorHandler: (Throwable) -> Unit = {}, action: suspend CoroutineScope.() -> Unit): Job =
    viewModelScope.launch {
        CoroutineExceptionHandler { coroutineContext, throwable -> errorHandler.invoke(throwable) }
        action.invoke(this)
    }