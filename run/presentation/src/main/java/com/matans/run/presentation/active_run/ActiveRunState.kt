package com.matans.run.presentation.active_run

import com.matans.core.doamin.location.Location
import com.matans.run.domain.RunData
import kotlin.time.Duration
import kotlin.time.Duration.Companion.ZERO

data class ActiveRunState(
    val elapsedTime: Duration = ZERO,
    val runData: RunData = RunData(),
    val shouldTrack: Boolean = false,
    val hasStartedRunning: Boolean = false,
    val currentLocation: Location? = null,
    val isRunFinished: Boolean = false,
    val isSavingRun: Boolean = false
)
