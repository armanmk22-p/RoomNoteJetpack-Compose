package com.example.mynotecomposeapplication.data.source.local.entity.presentation.listnote

import com.example.mynotecomposeapplication.domain.model.Note

data class ListNoteUiState(

    val notes :List<Note> = emptyList()
)
