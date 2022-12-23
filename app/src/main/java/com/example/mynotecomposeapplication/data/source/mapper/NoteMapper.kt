package com.example.mynotecomposeapplication.data.source.mapper

import com.example.mynotecomposeapplication.data.source.local.entity.NoteEntity
import com.example.mynotecomposeapplication.domain.model.Note

class NoteMapper {

    fun toNoteEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            title = note.title,
            description = note.description,
        )
    }

    fun toNote(noteEntity: NoteEntity): Note {
        return Note(
           id = noteEntity.id,
            title = noteEntity.title,
            description = noteEntity.description
        )
    }
}