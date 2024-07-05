package com.matans.core.doamin

data class AuthInfo(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)