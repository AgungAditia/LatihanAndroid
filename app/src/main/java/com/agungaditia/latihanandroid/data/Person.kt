package com.agungaditia.latihanandroid.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
// Membuat data class untuk menyimpan data
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable
