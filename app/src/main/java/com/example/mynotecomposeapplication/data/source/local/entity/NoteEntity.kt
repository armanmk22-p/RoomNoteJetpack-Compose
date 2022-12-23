package com.example.mynotecomposeapplication.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.util.Constants


@Entity(tableName = Constants.NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title : String,
    val description :String
)


fun NoteEntity.asNote() : Note {
    return Note(
        id = id,
        title = title,
        description = description
    )

    fun Note.asNoteEntity() :NoteEntity{
        return NoteEntity(
            id = id,
            title = title,
            description = description
        )
    }
}
