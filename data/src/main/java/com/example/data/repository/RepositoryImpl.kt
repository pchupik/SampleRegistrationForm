package com.example.data.repository

import com.example.domain.model.RegistrationResult
import com.example.domain.repository.Repository
import com.example.domain.model.User
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val dataSource: UserDataSource) : Repository {

    override suspend fun registerUser(user: User): RegistrationResult {
        return dataSource.registerUser(user)
    }
}