package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes: LiveData<List<Notes>> = TODO()

    init {
        val dao = NotesDatabase.getDatabase(application).getNoteDao()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }

}