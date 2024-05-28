package com.agungaditia.latihanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.agungaditia.latihanandroid.activity.BarVolumeActivity
import com.agungaditia.latihanandroid.databinding.ActivityMainBinding
import com.agungaditia.latihanandroid.fragment.HomeActivity
import com.agungaditia.latihanandroid.intent.MyIntentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // variable view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inisialisasi view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // menampilkan view binding

        // Untuk klik button
        binding.btnActivity.setOnClickListener {
            // Intent digunakan untuk berpindah halaman
            val intent = Intent(this, BarVolumeActivity::class.java)
            startActivity(intent) // -> Untuk menjalankan halaman
        }

        binding.btnIntent.setOnClickListener {
            // Intent digunakan untuk berpindah halaman
            val intent = Intent(this, MyIntentActivity::class.java)
            startActivity(intent) // -> Untuk menjalankan halaman
        }

        binding.btnFragment.setOnClickListener {
            // Intent digunakan untuk berpindah halaman
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent) // -> Untuk menjalankan halaman
        }
    }

}