package com.example.mynotecomposeapplication.presentation.addnote

sealed class AddNoteUiEvent{
    data class ShowSnackBar(val message :String) :AddNoteUiEvent()
}
