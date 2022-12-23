package com.example.mynotecomposeapplication.domain.usecase

import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note){
        return repository.deleteNote(note)
    }
}