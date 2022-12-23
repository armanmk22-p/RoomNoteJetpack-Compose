package com.example.mynotecomposeapplication.data.source.local.entity.presentation.listnote

import com.example.mynotecomposeapplication.data.source.local.entity.presentation.addnote.AddNoteUiEvent

sealed class ListNoteUiEvent{

    data class ShowSnackBar(val message :String) : ListNoteUiEvent()

}
