package com.example.data.repository

import com.example.domain.model.RegistrationResult
import com.example.domain.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject

class SimulatedDataSource @Inject constructor() : UserDataSource {

    override suspend fun registerUser(user: User): RegistrationResult {
        delay(1_000L)
        return when {
            user.name.isEmpty() -> RegistrationResult.Error("name must not be empty")
            user.email.isEmpty() -> RegistrationResult.Error("email must not be empty")
            else -> RegistrationResult.Success
        }
    }

}