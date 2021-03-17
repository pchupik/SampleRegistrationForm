package com.example.sampleregistrationform.di

import com.example.data.repository.RepositoryImpl
import com.example.data.repository.SimulatedDataSource
import com.example.data.repository.UserDataSource
import com.example.domain.interactors.RegisterUserUseCase
import com.example.domain.interactors.RegisterUserUseCaseImpl
import com.example.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module @InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    abstract fun bindRegisterUserUseCase(useCaseImpl: RegisterUserUseCaseImpl) : RegisterUserUseCase

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository

    @Binds
    abstract fun bindDataSource(dataSource: SimulatedDataSource) : UserDataSource
}