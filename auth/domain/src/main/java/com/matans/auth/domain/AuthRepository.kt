package com.matans.auth.domain

import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.EmptyResult

interface AuthRepository {

    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>

}