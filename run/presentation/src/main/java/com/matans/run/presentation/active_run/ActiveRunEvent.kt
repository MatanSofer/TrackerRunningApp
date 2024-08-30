package com.matans.run.presentation.active_run

import com.matans.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(var error: UiText): ActiveRunAction
    data object RunSaved:  ActiveRunAction
}