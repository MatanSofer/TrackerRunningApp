package com.example.trackerrunningapp.di


import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.trackerrunningapp.MainViewModel
import com.example.trackerrunningapp.RuniqueApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import javax.crypto.AEADBadTagException


val appModule = module {
    single<SharedPreferences> {
        createEncryptedSharedPreferences(androidApplication())
    }

    single<CoroutineScope> {
        (androidApplication() as RuniqueApp).applicationScope
    }

    viewModelOf(::MainViewModel)
}

fun createEncryptedSharedPreferences(context: Context): SharedPreferences {
    return try {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        EncryptedSharedPreferences.create(
            context,
            "auth_pref",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    } catch (e: AEADBadTagException) {
        // Data is corrupted, reset SharedPreferences
        context.getSharedPreferences("auth_pref", Context.MODE_PRIVATE).edit().clear().apply()

        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        EncryptedSharedPreferences.create(
            context,
            "auth_pref",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    } catch (e: Exception) {
        // If any other unexpected error occurs, fallback to normal SharedPreferences
        context.getSharedPreferences("auth_pref", Context.MODE_PRIVATE)
    }
}