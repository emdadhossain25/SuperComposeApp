package com.example.supercomposeapp.domain.reository

interface IAuthRepository {
    suspend fun login(email: String, password: String): Boolean
    suspend fun register(email: String, password: String): Boolean
}