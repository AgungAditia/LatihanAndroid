package com.agungaditia.latihanandroid.room

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.ActivityMyNoteBinding
import com.agungaditia.latihanandroid.room.adapter.NoteAdapter
import com.agungaditia.latihanandroid.room.ui.NoteAddUpdateActivity

class MyNoteActivity : AppCompatActivity() {

    private var _activityMyNoteBinding: ActivityMyNoteBinding? = null
    private val binding get() = _activityMyNoteBinding
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMyNoteBinding = ActivityMyNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.fabAdd?.setOnClickListener {
            val intent = Intent(this@MyNoteActivity, NoteAddUpdateActivity::class.java)
            startActivity(intent)
        }

        val noteViewModel = obtainViewModel(this@MyNoteActivity)
        noteViewModel.getAllNotes().observe(this) { noteList ->
            if (noteList != null) adapter.setListNotes(noteList)
        }

        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMyNoteBinding = null
    }

    private fun obtainViewModel(activity: AppCompatActivity): MyNoteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MyNoteViewModel::class.java]
    }
}