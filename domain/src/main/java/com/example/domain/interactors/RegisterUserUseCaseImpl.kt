package com.example.domain.interactors

import com.example.domain.model.RegistrationResult
import com.example.domain.model.User
import com.example.domain.repository.Repository
import javax.inject.Inject

class RegisterUserUseCaseImpl @Inject constructor(private val repository: Repository) : RegisterUserUseCase {

    override suspend fun invoke(user: User): RegistrationResult {
        return repository.registerUser(user)
    }
}