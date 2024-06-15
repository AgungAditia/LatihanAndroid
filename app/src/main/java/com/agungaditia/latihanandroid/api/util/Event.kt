package com.agungaditia.latihanandroid.api.util

open class Event<out T>(private val content: T) {

    // T -> adalah tipe data generic yang supaya bisa membungkus berbagai macam data
    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandle = false // Untuk mengecek apakah sudah dihandle atau belum
        private set

    // Fungsi Utama Event
    fun getContentIfNotHandle(): T? {
        return if (hasBeenHandle) {
            null
        } else {
            hasBeenHandle = true
            content
        }
    }

    fun peekContent(): T = content
}