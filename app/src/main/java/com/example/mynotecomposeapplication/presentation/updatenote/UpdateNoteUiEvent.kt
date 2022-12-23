package com.example.mynotecomposeapplication.presentation.updatenote

sealed class UpdateNoteUiEvent{
    data class ShowSnackBar(val message :String) :UpdateNoteUiEvent()
}