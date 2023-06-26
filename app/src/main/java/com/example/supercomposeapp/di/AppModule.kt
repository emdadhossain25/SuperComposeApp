package com.example.supercomposeapp.di

import com.example.supercomposeapp.data.AuthRepositoryImpl
import com.example.supercomposeapp.domain.reository.IAuthRepository
import com.example.supercomposeapp.domain.use_case.ValidateLoginInputUseCase
import com.example.supercomposeapp.domain.use_case.ValidateRegistrationInputUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun validateLoginInputUseCase(): ValidateLoginInputUseCase {
        return ValidateLoginInputUseCase()
    }

    @Provides
    @Singleton
    fun validateRegistrationInputUseCase(): ValidateRegistrationInputUseCase {
        return ValidateRegistrationInputUseCase()
    }

    @Provides
    @Singleton
    fun providesAuthRepository(): IAuthRepository {
        return AuthRepositoryImpl()
    }
}