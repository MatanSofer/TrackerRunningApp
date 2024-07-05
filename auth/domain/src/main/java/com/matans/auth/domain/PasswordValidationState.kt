package com.matans.auth.domain

data class PasswordValidationState(
    val hasMinLenght: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacters: Boolean = false,
){
    val isValidPassword: Boolean
        get() = hasMinLenght && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacters
}
