package com.example.trackerrunningapp

import android.app.Application
import com.example.trackerrunningapp.di.appModule
import com.matans.auth.data.di.authDataModule
import com.matans.auth.presentation.di.authViewModelModule

import com.matans.trackerrunningapp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin{
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule
            )
        }
    }
}