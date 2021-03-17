package com.example.data.repository

import com.example.domain.model.RegistrationResult
import com.example.domain.model.User

interface UserDataSource {

    suspend fun registerUser(user: User) : RegistrationResult
}

