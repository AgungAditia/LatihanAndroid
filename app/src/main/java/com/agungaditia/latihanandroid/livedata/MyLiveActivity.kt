package com.agungaditia.latihanandroid.livedata

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityMyLiveBinding

class MyLiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyLiveBinding
    private lateinit var liveDataTimerViewModel: MyLiveViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // -> Untuk memanggil ViewModel
        liveDataTimerViewModel = ViewModelProvider(this)[MyLiveViewModel::class.java]
        subscriber() // -> Untuk memanggil subscriber
    }

    private fun subscriber() {
        // -> Untuk memanggil liveData
        val elapsedTimeObserver = Observer<Long?> { aLong ->
            val newText =
                this.resources.getString(R.string.seconds, aLong) // -> Untuk memanggil string
            binding.timerTextview.text = newText // -> Untuk memanggil textview
        }

        // Untuk memanggil liveData
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}