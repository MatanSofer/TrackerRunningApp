package com.matans.run.presentation.active_run.maps

import androidx.compose.ui.graphics.Color
import com.matans.core.doamin.location.Location

data class PolylineUi(
    val location1: Location,
    val location2: Location,
    val color: Color
)
