package com.matans.core.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Composable
fun <T> ObserveAsEvents (
    flow: Flow<T>,
    key1: Any? = null, //keys to re execute the launch effect when they change
    key2: Any? = null,
    onEvent: (T) -> Unit   //reveive an event that comes from view model
){
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(flow,lifecycleOwner.lifecycle,key1,key2) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
            withContext(Dispatchers.Main.immediate){
                flow.collect(onEvent)
            }
        }
    }
}

