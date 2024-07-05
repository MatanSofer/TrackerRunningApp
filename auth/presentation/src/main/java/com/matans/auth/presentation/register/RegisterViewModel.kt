package com.matans.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.matans.auth.domain.AuthRepository
import com.matans.auth.domain.UserDataValidator
import com.matans.auth.presentation.R
import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.Result
import com.matans.core.presentation.ui.UiText
import com.matans.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
    private val repository: AuthRepository
): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val eventChnnel = Channel<RegisterEvent>()
    val events = eventChnnel.receiveAsFlow()

    init {
        state.email.textAsFlow()
            .onEach { email ->
                val isValidEmail = userDataValidator.isValidEmail(email.toString())
                state = state.copy(
                    isEmailValid = isValidEmail,
                    canRegister = isValidEmail && state.passwordValidationState.isValidPassword
                            && !state.isRegistering
                )
            }.launchIn(viewModelScope)

        state.password.textAsFlow()
            .onEach { password ->
                val passwordValidationState = userDataValidator.validatePassword(password.toString())
                state = state.copy(
                    passwordValidationState = passwordValidationState,
                    canRegister = state.isEmailValid && passwordValidationState.isValidPassword
                            && !state.isRegistering
                )
            }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction){
        when(action){
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }
            else -> Unit
        }
    }

    private fun register(){
        viewModelScope.launch {
            state = state.copy(isRegistering =  true)
            val result = repository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isRegistering = false)
            when(result){
                is Result.Error -> {
                    if(result.error == DataError.Network.CONFLICT){
                        eventChnnel.send(RegisterEvent.Error(
                           UiText.StringResource(R.string.error_email_exist)
                        ))
                    }else{
                        eventChnnel.send(RegisterEvent.Error(result.error.asUiText()))
                    }
                }
                is Result.Success -> {
                    eventChnnel.send(RegisterEvent.RegistrationSuccess)

                }
            }
        }
    }
}