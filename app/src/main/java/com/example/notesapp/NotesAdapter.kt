package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.NotesAdapter.*

class NotesAdapter(val context: Context, val listener: NotesClickListener) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Notes>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textNote = itemView.findViewById<TextView>(R.id.textNote)
        val btnDelete = itemView.findViewById<ImageButton>(R.id.imageDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
         val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_items, parent, false))
         viewHolder.btnDelete.setOnClickListener(View.OnClickListener {

             listener.onNoteClicked(allNotes[viewHolder.adapterPosition])

         })
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textNote.text = currentNote.note
    }

    fun updateList(noteList: List<Notes>) {

        allNotes.clear()
        allNotes.addAll(noteList)
        notifyDataSetChanged()

    }

    interface NotesClickListener {

        fun onNoteClicked(notes: Notes)
    }



}