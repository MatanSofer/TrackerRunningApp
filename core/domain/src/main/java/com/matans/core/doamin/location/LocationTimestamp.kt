package com.matans.core.doamin.location

import kotlin.time.Duration

data class LocationTimestamp(
    val location: LocationWithAltitude,
    val durationTimestamp: Duration
)
