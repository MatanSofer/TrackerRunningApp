package com.matans.core.database

import android.database.sqlite.SQLiteFullException
import com.matans.core.database.dao.RunDao
import com.matans.core.database.mappers.toRun
import com.matans.core.database.mappers.toRunEntity
import com.matans.core.doamin.run.LocalRunDataSource
import com.matans.core.doamin.run.Run
import com.matans.core.doamin.run.RunId
import com.matans.core.doamin.util.DataError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.matans.core.doamin.util.Result

class RoomLocalRunDataSource(
    private val runDao: RunDao
): LocalRunDataSource {

    override fun getRuns(): Flow<List<Run>> {
        return runDao.getRuns()
            .map { runEntities ->
                runEntities.map { it.toRun() }
            }
    }

    override suspend fun upsertRun(run: Run): Result<RunId, DataError.Local> {
        return try {
            val entity = run.toRunEntity()
            runDao.upsertRun(entity)
            Result.Success(entity.id)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local> {
        return try {
            val entities = runs.map { it.toRunEntity() }
            runDao.upsertRuns(entities)
            Result.Success(entities.map { it.id })
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteRun(id: String) {
        runDao.deleteRun(id)
    }

    override suspend fun deleteAllRuns() {
        runDao.deleteAllRuns()
    }
}