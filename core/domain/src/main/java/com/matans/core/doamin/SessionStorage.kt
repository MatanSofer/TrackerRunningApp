package com.matans.core.doamin.util

import com.matans.core.doamin.AuthInfo

interface SessionStorage {

    suspend fun get(): AuthInfo?
    suspend fun set(info: AuthInfo?)
}