package ru.marslab.marslablib

sealed class UiState<out D, out E> {
    object Init : UiState<Nothing, Nothing>()
    data class Success<out D>(val data: D) : UiState<D, Nothing>()
    data class Error<out E>(val error: E) : UiState<Nothing, E>()
    data class Loading(val progress: Float?) : UiState<Nothing, Nothing>()
}
