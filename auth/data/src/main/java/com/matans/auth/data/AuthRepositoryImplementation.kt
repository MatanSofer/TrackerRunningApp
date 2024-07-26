package com.matans.auth.data

import com.matans.auth.domain.AuthRepository
import com.matans.core.data.networking.post
import com.matans.core.doamin.AuthInfo
import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.EmptyResult
import com.matans.core.doamin.util.Result
import com.matans.core.doamin.util.SessionStorage
import com.matans.core.doamin.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImplementation(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest,LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success){
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

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