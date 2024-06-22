package com.agungaditia.latihanandroid.room.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.agungaditia.latihanandroid.room.database.Note
import com.agungaditia.latihanandroid.room.database.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}