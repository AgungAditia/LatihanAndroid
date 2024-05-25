package com.agungaditia.latihanandroid.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityMyIntentBinding

class MyIntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMyIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMove.setOnClickListener(this)
        binding.btnMoveData.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_move -> {
                val moveIntent = Intent(this@MyIntentActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_data -> {
                val moveDataIntent = Intent(this@MyIntentActivity, MoveDataActivity::class.java)
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "Hanif Azizah")
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_AGE, 22)
                startActivity(moveDataIntent)
            }
        }
    }
}