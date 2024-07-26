package com.matans.auth.domain

import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.EmptyResult

interface AuthRepository {

    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>

}