package com.matans.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matans.core.database.dao.AnalyticsDao
import com.matans.core.database.dao.RunDao
import com.matans.core.database.dao.RunPendingSyncDao
import com.matans.core.database.entity.DeletedRunSyncEntity
import com.matans.core.database.entity.RunEntity
import com.matans.core.database.entity.RunPendingSyncEntity


@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}