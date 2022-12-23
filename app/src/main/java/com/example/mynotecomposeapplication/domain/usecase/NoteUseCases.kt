package com.example.mynotecomposeapplication.domain.usecase

data class NoteUseCases(

    val deleteNoteUseCase: DeleteNoteUseCase,
    val getAllNotesUseCase: GetAllNotesUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase,
    val insertNoteUseCase: InsertNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase
)
