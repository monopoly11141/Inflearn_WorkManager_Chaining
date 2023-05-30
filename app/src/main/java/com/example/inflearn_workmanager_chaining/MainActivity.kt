package com.example.inflearn_workmanager_chaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerA, workManagerB))
            .then(workManagerC).enqueue()
    }
}