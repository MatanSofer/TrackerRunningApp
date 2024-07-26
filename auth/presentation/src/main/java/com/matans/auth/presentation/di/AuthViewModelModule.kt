package com.matans.auth.presentation.di

import com.matans.auth.domain.PatternValidator
import com.matans.auth.presentation.login.LoginViewModel
import com.matans.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}