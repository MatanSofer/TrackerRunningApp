package com.matans.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}