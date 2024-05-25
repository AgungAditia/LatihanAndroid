package com.agungaditia.latihanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.agungaditia.latihanandroid.barVolume.BarVolumeActivity
import com.agungaditia.latihanandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActivity.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_activity -> {
                val intent = Intent(this@MainActivity, BarVolumeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}