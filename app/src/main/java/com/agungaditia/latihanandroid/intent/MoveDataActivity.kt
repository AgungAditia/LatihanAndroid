package com.agungaditia.latihanandroid.intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityMoveDataBinding

class MoveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveDataBinding // Variable  view binding

    // Key untuk menerima data dari activity sebelumnya
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi view binding
        binding = ActivityMoveDataBinding.inflate(layoutInflater)
        setContentView(binding.root) // Menampilkan layout dengan view binding

        val name = intent.getStringExtra(EXTRA_NAME) // Mendapatkan data dari intent dengan key EXTRA_NAME
        val age = intent.getIntExtra(EXTRA_AGE, 0) // Mendapatkan data dari intent dengan key EXTRA_AGE

        val text = "Name : $name, Your Age : $age" // Menampilkan teks dengan data yang diterima
        binding.dataReceived.text = text // Menampilkan teks pada TextView dataReceived
    }
}