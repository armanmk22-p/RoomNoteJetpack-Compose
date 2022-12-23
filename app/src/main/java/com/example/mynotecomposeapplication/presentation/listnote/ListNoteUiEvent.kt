package com.example.mynotecomposeapplication.presentation.listnote

import com.example.mynotecomposeapplication.presentation.addnote.AddNoteUiEvent

sealed class ListNoteUiEvent{

    data class ShowSnackBar(val message :String) : ListNoteUiEvent()

}
