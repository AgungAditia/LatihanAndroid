package com.agungaditia.latihanandroid.intent

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.data.Person
import com.agungaditia.latihanandroid.databinding.ActivityLatihanObjectBinding

class LatihanObjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanObjectBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_NAME, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_NAME)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()}, \nAge : ${person.age.toString()}"
            binding.tvObjectDiterima.text = text
        }
    }
}