package com.matans.run.di

import com.matans.core.doamin.run.SyncRunScheduler
import com.matans.run.data.CreateRunWorker
import com.matans.run.data.DeleteRunWorker
import com.matans.run.data.FetchRunsWorker
import com.matans.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}