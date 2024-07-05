package com.matans.auth.data.di

import com.matans.auth.data.AuthRepositoryImplementation
import com.matans.auth.data.EmailPattrenValidator
import com.matans.auth.domain.AuthRepository
import com.matans.auth.domain.PatternValidator
import com.matans.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPattrenValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImplementation).bind<AuthRepository>()
}