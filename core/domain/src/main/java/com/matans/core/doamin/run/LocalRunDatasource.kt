package com.matans.core.doamin.run

import com.matans.core.doamin.util.DataError
import kotlinx.coroutines.flow.Flow
import com.matans.core.doamin.util.Result

typealias RunId = String

interface LocalRunDataSource {
    fun getRuns(): Flow<List<Run>>
    suspend fun upsertRun(run: Run): Result<RunId, DataError.Local>
    suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local>
    suspend fun deleteRun(id: String)
    suspend fun deleteAllRuns()
}