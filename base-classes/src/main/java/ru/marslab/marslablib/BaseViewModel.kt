/*
 * Copyright (c) $2022
 * Created by Sergey Aristov
 */

package ru.marslab.marslablib

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Base class ViewModel for use in Fragment
 *
 * In the class use field uiData with user data.
 *
 * @author Sergey Aristov
 *
 * @param D
 * type of data which storage in viewmodel
 *
 * тип данных для хранения во вьюмодели
 *
 * @param E
 * type of data which receive from error state. In most cases used Throwable
 *
 * тип данных при передаче статуса error. В большенстве случаев используется Throwable
 */
abstract class BaseViewModel<D : Any, E : Any> : ViewModel() {
    private var uiData: D? = null

    private val _uiState: MutableStateFlow<UiState<D, E>> = MutableStateFlow(UiState.Init)
    val uiState: StateFlow<UiState<D, E>> =
        _uiState.asStateFlow()

    open fun setLoadingState(progress: Float? = null) {
        _uiState.tryEmit(UiState.Loading(progress))
    }

    open fun setSuccessfulState(data: D) {
        uiData = data
        _uiState.tryEmit(UiState.Success(data))
    }

    open fun setErrorState(error: E) {
        _uiState.tryEmit(UiState.Error(error))
    }
}
