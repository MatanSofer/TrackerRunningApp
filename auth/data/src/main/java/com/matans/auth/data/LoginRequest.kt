package com.matans.auth.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)
