package com.example.run.network.di

import com.example.run.network.KtorRemoteRunDataSource
import com.matans.core.doamin.run.RemoteRunDatasource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDatasource>()
}