package com.example.mynotecomposeapplication.data.source.repositoryimpl

import com.example.mynotecomposeapplication.data.source.local.NoteDao
import com.example.mynotecomposeapplication.data.source.mapper.NoteMapper
import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class NoteRepositoryImpl(
    private val noteDao: NoteDao,
    private val noteMapper: NoteMapper
    ) :NoteRepository{

    /** all functions below must convert to model because note or notes should be display in ui
     * so we must get them from entity and then convert it to model , then viewModel can use them and
     * pass them to ui to show them **/
    override fun getAllNotes(): Flow<List<Note>> {
        val response = noteDao.getAllNotes()
        return response.map {
            it.map {
                noteMapper.toNote(it)
            }
        }
    }

    override fun getNote(id: Int): Flow<Note> {
        val response = noteDao.getNote(id)
        return response.map {
            noteMapper.toNote(it)
        }

    }
    /** ===================================================================================== **/

/** all functions below must convert to entity because note in each function comes from domain model
  an should pass to entity to do that work such as delete note or update note **/
    override suspend fun insertNote(note: Note) {
        return noteDao.insertNote(noteMapper.toNoteEntity(note))
    }

    override suspend fun updateNote(note: Note) {
        return noteDao.updateNote(noteMapper.toNoteEntity(note))
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(noteMapper.toNoteEntity(note))
    }
}