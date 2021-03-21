package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//table and columns
@Entity(tableName = "notes_table")
class Notes(@ColumnInfo(name = "Col_Note") val note: String) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Col_Id") var id: Int = 0

}