package com.matans.auth.presentation.register

import com.matans.core.presentation.ui.UiText

sealed interface RegisterEvent {

    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}