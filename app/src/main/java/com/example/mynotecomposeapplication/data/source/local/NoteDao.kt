package com.example.mynotecomposeapplication.data.source.local

import androidx.room.*
import com.example.mynotecomposeapplication.data.source.local.entity.NoteEntity
import com.example.mynotecomposeapplication.util.Constants.Companion.NOTE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM $NOTE_TABLE ORDER BY id ASC ")
    fun getAllNotes():Flow<List<NoteEntity>>

    @Query("SELECT * FROM $NOTE_TABLE WHERE id = :id")
    fun getNote(id :Int):Flow<NoteEntity>

    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}