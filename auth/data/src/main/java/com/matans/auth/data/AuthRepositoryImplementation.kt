package com.matans.auth.data

import com.matans.auth.domain.AuthRepository
import com.matans.core.data.networking.post
import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImplementation(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}