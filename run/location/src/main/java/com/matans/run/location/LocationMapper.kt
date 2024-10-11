package com.matans.run.location

import android.location.Location
import com.matans.core.doamin.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude{
    return LocationWithAltitude(
        location = com.matans.core.doamin.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}