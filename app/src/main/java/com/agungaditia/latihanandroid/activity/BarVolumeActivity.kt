package com.agungaditia.latihanandroid.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityBarVolumeBinding

class BarVolumeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityBarVolumeBinding // -> variable binding

    // Untuk menyimpan state jika emulator/ hp di rotasi
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityBarVolumeBinding.inflate(layoutInflater) // -> Untuk menginisialisasi view binding
        setContentView(binding.root) // -> Untuk menampilkan view binding

        binding.btnCalculate.setOnClickListener(this) // -> Untuk memanggil method onClick

        // Untuk menyimpan state jika emulator/ hp di rotasi
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }

    }

    // Mengiisialisasi state & data
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // -> Untuk menyimpan data pada saat rotasi
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    // Menginisialisasi Method onClick
    override fun onClick(view: View?) {
        // -> Cek id dari button
        if (view?.id == R.id.btn_calculate) {

            // -> Mengambil data dari EditText
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            var isEmptyFields = false // -> Untuk cek data kosong

            // -> Cek data kosong di setiap EditText/Field
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            // -> Cek data tidak kosong
            if (!isEmptyFields) {
                // -> Untuk menghitung volume
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvResult.text = volume.toString() // -> Untuk menampilkan hasil
            }
        }
    }
}