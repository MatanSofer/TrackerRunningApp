package com.matans.core.doamin.run

import com.matans.core.doamin.util.DataError
import com.matans.core.doamin.util.EmptyResult
import com.matans.core.doamin.util.Result
import javax.xml.crypto.Data

interface RemoteRunDatasource {
    suspend fun getRuns(): Result<List<Run>,DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}