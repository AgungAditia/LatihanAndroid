package com.agungaditia.latihanandroid.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agungaditia.latihanandroid.R

class HomeActivity : AppCompatActivity() {

    private val dataString : String = "Helo ini adalah data string"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val transaction = supportFragmentManager.beginTransaction()
        val firstFragment = FirstFragment()

        transaction.replace(R.id.frame_container, firstFragment)
        transaction.commit()
    }
}