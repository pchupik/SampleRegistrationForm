package com.example.sampleregistrationform.ui.registration

sealed class ViewState {
    object Success : ViewState()
    class Error(val msg: String) : ViewState()
    object Loading : ViewState()
    object Waiting : ViewState()
}
