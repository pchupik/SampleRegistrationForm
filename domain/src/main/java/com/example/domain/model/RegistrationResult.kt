package com.example.domain.model

sealed class RegistrationResult {
    object Success : RegistrationResult()
    class Error(val msg: String) : RegistrationResult()
}

