package com.example.mynotecomposeapplication.domain.usecase

import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNoteByIdUseCase(private val repository: NoteRepository) {

    operator fun invoke(id:Int):Flow<Note>{
        return  repository.getNote(id)
    }
}