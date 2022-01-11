package ru.marslab.marslablib.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ru.marslab.marslablib.UiState

abstract class BaseComposeViewModel<D : Any, E : Any> : ViewModel() {
    var uiState by mutableStateOf<UiState<D, E>>(UiState.Init)
        private set

    open fun setLoading(progress: Float? = null) {
        uiState = UiState.Loading(progress)
    }

    open fun setSuccessful(data: D) {
        uiState = UiState.Success(data)
    }

    open fun setError(error: E) {
        uiState = UiState.Error(error)
    }
}
