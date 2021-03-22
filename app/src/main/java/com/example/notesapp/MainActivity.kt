package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NotesAdapter.NotesClickListener {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener(View.OnClickListener {

            val noteText = editTextNote.text.toString()
            if (noteText.isNotEmpty()) {

                noteViewModel.insertNote(Notes(noteText))
            }

        })

        noteRV.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this, this)
        noteRV.adapter = adapter

        noteViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.
        getInstance(application)).
        get(NoteViewModel::class.java)



        noteViewModel.allNotes.observe(this, Observer {list -> list.let {
            adapter.updateList(it)

        }


        })

    }

    override fun onNoteClicked(notes: Notes) {
        noteViewModel.deleteNote(notes)
    }
}