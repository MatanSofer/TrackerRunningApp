package com.matans.run.domain

import com.matans.core.doamin.location.Location
import com.matans.core.doamin.location.LocationTimestamp
import kotlin.time.Duration

data class RunData(
    val distanceMeters: Int = 0,
    val pace: Duration = Duration.ZERO,
    val locations: List<List<LocationTimestamp>> = emptyList(), // if user paused , in general each line is list of location so we need list of lines


)
