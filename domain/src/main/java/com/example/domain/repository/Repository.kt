package com.example.domain.repository

import com.example.domain.model.RegistrationResult
import com.example.domain.model.User

interface Repository {

    suspend fun registerUser(user: User) : RegistrationResult
}