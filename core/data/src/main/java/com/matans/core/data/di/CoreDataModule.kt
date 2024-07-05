package com.matans.core.data.di

import android.content.SharedPreferences
import com.matans.core.data.auth.EncryptedSessionStorage
import com.matans.core.data.networking.HttpClientFactory
import com.matans.core.doamin.util.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single{
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

}