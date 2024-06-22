package com.agungaditia.latihanandroid.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.agungaditia.latihanandroid.room.database.Note
import com.agungaditia.latihanandroid.room.database.NoteRepository

class MyNoteViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNote()
}