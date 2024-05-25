package com.agungaditia.latihanandroid.barVolume

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityBarVolumeBinding

class BarVolumeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityBarVolumeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarVolumeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate){
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
            binding.tvResult.text = volume.toString()
        }
    }
}