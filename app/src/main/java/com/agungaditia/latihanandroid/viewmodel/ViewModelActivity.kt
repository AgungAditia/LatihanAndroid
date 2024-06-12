package com.agungaditia.latihanandroid.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding
//    private lateinit var viewModel: ViewViewModel

    private val viewModel by viewModels<ViewViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Untuk menyambungkan viewmodel dengan activity
//        viewModel = ViewModelProvider(this).get(ViewViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener {


            val width = binding.edtWidth.text.toString().toInt()
            val height = binding.edtHeight.text.toString().toInt()
            val length = binding.edtLength.text.toString().toInt()

            when {
                width.toString().isEmpty() -> {
                    binding.edtWidth.error = "Field ini tidak boleh kosong"
                }

                height.toString().isEmpty() -> {
                    binding.edtHeight.error = "Field ini tidak boleh kosong"
                }

                length.toString().isEmpty() -> {
                    binding.edtLength.error = "Field ini tidak boleh kosong"
                }

                else -> {
                    viewModel.calculate(width.toString(), height.toString(), length.toString())
                    displayResult()
                }
            }
        }

    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}