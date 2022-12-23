package com.example.mynotecomposeapplication.data.source.local.entity.presentation.updatenote

sealed class UpdateNoteUiEvent{
    data class ShowSnackBar(val message :String) : UpdateNoteUiEvent()
}