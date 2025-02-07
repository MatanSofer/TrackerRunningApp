package com.matans.analytics.presentation

sealed  interface AnalyticsAction {
    data object OnBackClicked: AnalyticsAction
}