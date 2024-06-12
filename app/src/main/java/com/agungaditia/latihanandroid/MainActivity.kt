package com.agungaditia.latihanandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agungaditia.latihanandroid.activity.BarVolumeActivity
import com.agungaditia.latihanandroid.databinding.ActivityMainBinding
import com.agungaditia.latihanandroid.fragment.FragmentActivity
import com.agungaditia.latihanandroid.fragment.HomeFragment
import com.agungaditia.latihanandroid.intent.MyIntentActivity
import com.agungaditia.latihanandroid.navigation.NavActivity
import com.agungaditia.latihanandroid.recyclerview.RecyclerViewActivity
import com.agungaditia.latihanandroid.viewgroup.ConstrainViewActivity
import com.agungaditia.latihanandroid.viewgroup.ViewActivity

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
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent) // -> Untuk menjalankan halaman
        }

        binding.btnView.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnConstraint.setOnClickListener {
            val intent = Intent(this, ConstrainViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecylerview.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnNavigation.setOnClickListener {
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
    }

}