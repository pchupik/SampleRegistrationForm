package com.example.domain.interactors

import com.example.domain.model.RegistrationResult
import com.example.domain.model.User

interface RegisterUserUseCase {

    suspend fun invoke(user: User): RegistrationResult
}