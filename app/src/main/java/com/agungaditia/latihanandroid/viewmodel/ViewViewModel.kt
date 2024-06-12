package com.agungaditia.latihanandroid.viewmodel

import android.health.connect.datatypes.units.Length
import androidx.lifecycle.ViewModel

class ViewViewModel : ViewModel() {
    var result = 0

    fun calculate(widht: String, height: String, length: String) {
        result = widht.toInt() * height.toInt() * length.toInt()
    }
}