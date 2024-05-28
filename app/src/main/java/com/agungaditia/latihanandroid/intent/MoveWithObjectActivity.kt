package com.agungaditia.latihanandroid.intent

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.data.Person
import com.agungaditia.latihanandroid.databinding.ActivityMoveWithObjectBinding

class MoveWithObjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveWithObjectBinding // Variable view binding

    // Melakukan deklarasi key untuk data
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // cek version android
        val person = if (Build.VERSION.SDK_INT >= 33) {
            // Jika version android >= 33 maka gunakan getParcelableExtra
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            // Jika version android < 33 maka gunakan getParcelableExtra
            @Suppress("DEPRECATION") // -> Untuk mencegah error
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        // Melakukan pengecekan data
        if (person != null) { // Jika data tidak null
            // Menampilkan data
            val text =
                "Name :${person.name.toString()},  \nEmail :${person.email.toString()} , \nAge :${person.age.toString()} \nLocation :${person.city.toString()}"
            binding.tvObjectReceived.text = text // -> Menampilkan data pada textview
        }
    }
}