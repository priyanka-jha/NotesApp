package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

//to perform operations/queries
@Dao
interface NoteDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)  //ignore/don't insert the duplicate value
    suspend fun insert(notes: Notes)

    @Delete
    suspend fun delete(notes: Notes)

    @Query("Select * from notes_table order by Col_Id")
    fun getAll(): LiveData<List<Notes>>

}