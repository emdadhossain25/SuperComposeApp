package com.example.supercomposeapp.data

import com.example.supercomposeapp.domain.reository.IAuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl : IAuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        delay(1000)
        return true
    }

    override suspend fun register(email: String, password: String): Boolean {
        delay(1000)
        return true
    }
}