package com.matans.core.data.di

import com.matans.core.data.networking.HttpClientFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreDataModule = module {
    single{
        HttpClientFactory().build()
    }
}