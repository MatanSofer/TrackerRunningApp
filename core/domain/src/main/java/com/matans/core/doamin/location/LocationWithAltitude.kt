package com.matans.core.doamin.location

data class LocationWithAltitude(
    val location: Location,
    val altitude: Double // to compute total gained elevation of a specific run
)
