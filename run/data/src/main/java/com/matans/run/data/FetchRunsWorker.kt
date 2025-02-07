package com.matans.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.matans.core.doamin.run.RunRepository
import com.matans.core.doamin.util.Result
class FetchRunsWorker(
    context: Context,
    params: WorkerParameters,
    private val runRepository: RunRepository
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if(runAttemptCount >= 5) {
            return Result.failure()
        }
        return when(val result = runRepository.fetchRuns()) {
            is com.matans.core.doamin.util.Result.Error -> {
                result.error.toWorkerResult()
            }
            is com.matans.core.doamin.util.Result.Success -> Result.success()
        }
    }
}