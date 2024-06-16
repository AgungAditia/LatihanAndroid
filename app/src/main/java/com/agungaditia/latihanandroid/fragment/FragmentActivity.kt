package com.agungaditia.latihanandroid.fragment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.agungaditia.latihanandroid.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

//        if (fragment !is HomeFragment) {
//            Log.d("FragmentActivity", "Fragment Name :" + HomeFragment::class.java.simpleName)
//            fragmentManager
//                .beginTransaction()
//                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
//                .commit()
//        }

        // Dengan Fragment KTX
        if (fragment !is HomeFragment) {
            Log.d("Fragment Activity", "Fragment Name :" + HomeFragment::class.java.simpleName)
            fragmentManager.commit {
                add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
            }
        }
    }
}