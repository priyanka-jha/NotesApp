package com.example.notesapp

import androidx.lifecycle.LiveData

public class NotesRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Notes>> = noteDao.getAll()

    suspend fun insert(notes: Notes){
        noteDao.insert(notes)
    }

    suspend fun delete(notes: Notes){
        noteDao.delete(notes)
    }


}