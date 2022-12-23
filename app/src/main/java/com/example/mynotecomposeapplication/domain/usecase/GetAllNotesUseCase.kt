package com.example.mynotecomposeapplication.domain.usecase

import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke():Flow<List<Note>>{
        return repository.getAllNotes()
    }
}