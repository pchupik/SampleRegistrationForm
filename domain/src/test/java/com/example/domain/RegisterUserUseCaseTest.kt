package com.example.domain

import com.example.domain.interactors.RegisterUserUseCaseImpl
import com.example.domain.model.RegistrationResult.*
import com.example.domain.model.User
import com.example.domain.repository.Repository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class RegisterUserUseCaseTest {

    private val repository: Repository = mock()
    private val useCase = RegisterUserUseCaseImpl(repository)

    @Test
    fun `use case calls Repository`() {
        val user = User("name", "mail")
        runBlocking {

            useCase.invoke(user)
            verify(repository).registerUser(user)
        }
    }

    @Test
    fun `use case returns result from repository`() {
        val successUser = User("success","")
        val errorUser = User("fail","")
        val theError = Error("the error")
        runBlocking {
            whenever(repository.registerUser(successUser)).thenReturn(Success)
            whenever(repository.registerUser(errorUser)).thenReturn(theError)

            assertEquals(Success, useCase.invoke(successUser))
            assertEquals(theError, useCase.invoke(errorUser))
        }
    }
}