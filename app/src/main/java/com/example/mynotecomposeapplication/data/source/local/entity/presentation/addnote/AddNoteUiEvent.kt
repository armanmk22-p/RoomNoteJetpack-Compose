package com.example.mynotecomposeapplication.data.source.local.entity.presentation.addnote

sealed class AddNoteUiEvent{
    data class ShowSnackBar(val message :String) : AddNoteUiEvent()
}
