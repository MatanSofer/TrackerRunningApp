package com.example.trackerrunningapp

import android.app.Application
import com.example.trackerrunningapp.di.appModule
import com.matans.auth.data.di.authDataModule
import com.matans.auth.presentation.di.authViewModelModule
import com.matans.core.data.di.coreDataModule
import com.matans.core.database.di.databaseModule
import com.matans.run.location.di.locationModule
import com.matans.run.presentation.di.runPresentationModule

import com.matans.trackerrunningapp.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class RuniqueApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule
            )
        }
    }
}