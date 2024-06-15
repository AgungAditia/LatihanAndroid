package com.agungaditia.latihanandroid.livedata

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class MyLiveViewModel : ViewModel() {

    companion object {
        private const val ONE_SECOND = 1000
    }

    private val mInitialTime = SystemClock.elapsedRealtime()
    private val mElapsedTime = MutableLiveData<Long>() // Bisa diubah valuenya

    init {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                // postValue -> Untuk merubah valuenya
                // setValue -> Untuk menetapkan valuenya
                // getValue -> Untuk mendapatkan valuenya
                mElapsedTime.postValue(newValue) // -> Yang dimaksud merubah valuenya
            }

        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    // LiveData -> Bersifat Read Only / Immutable / Tidak bisa diubah
    fun getElapsedTime(): LiveData<Long> {
        return mElapsedTime
    }

}