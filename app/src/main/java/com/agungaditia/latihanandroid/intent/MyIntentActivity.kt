package com.agungaditia.latihanandroid.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.data.Person
import com.agungaditia.latihanandroid.databinding.ActivityMyIntentBinding

class MyIntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMyIntentBinding // -> Variable view binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi view binding
        binding = ActivityMyIntentBinding.inflate(layoutInflater)
        setContentView(binding.root) // -> Menampilkan view binding

        // Inisialisasi view untuk di klik
        binding.btnMove.setOnClickListener(this)
        binding.btnMoveData.setOnClickListener(this)
        binding.btnMoveObject.setOnClickListener(this)
        binding.btnLatihanObject.setOnClickListener(this)
    }

    // Fungsi onClick
    override fun onClick(view: View?) {
        // menggunakan when untuk memanggil view dengan id
        when (view?.id) {
            // Pindah ke halaman MoveActivity tanpa data
            R.id.btn_move -> {
                val moveIntent = Intent(this@MyIntentActivity, MoveActivity::class.java)
                startActivity(moveIntent) // -> Memulai aktivitas
            }

            // Pindah ke halaman MoveActivity dengan data
            R.id.btn_move_data -> {
                val moveDataIntent = Intent(this@MyIntentActivity, MoveDataActivity::class.java)

                // Mengirim data ke halaman MoveActivity menggunakan putExtra
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "Hanif Azizah") // -> String
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_AGE, 22) // -> Integer
                startActivity(moveDataIntent) // -> Memulai aktivitas
            }

            // Pindah ke halaman MoveActivity dengan object
            R.id.btn_move_object -> {
                val person = Person("Hanif Azizah", 22, "ahaidenip9@gmail.com", "Depok")
                val moveObjectIntent =
                    Intent(this@MyIntentActivity, MoveWithObjectActivity::class.java)
                moveObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveObjectIntent)

            }

            R.id.btn_latihan_object -> {
                val person = Person("Agung Aditia", 21, "habsyah10@gmail.com", "Depok")
                val moveObjectIntent =
                    Intent(this@MyIntentActivity, LatihanObjectActivity::class.java)
                moveObjectIntent.putExtra(LatihanObjectActivity.EXTRA_NAME, person)
                startActivity(moveObjectIntent)
            }
        }
    }
}