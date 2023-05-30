package com.example.inflearn_workmanager_chaining

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerC(context : Context, workerParams : WorkerParameters) : Worker(context, workerParams) {

    private val TAG = this::class.java.simpleName

    override fun doWork(): Result {

       for(i in 1..3) {
           sleep(1_000)
           Log.d(TAG, "$i")
       }

        return Result.success()

    }

}