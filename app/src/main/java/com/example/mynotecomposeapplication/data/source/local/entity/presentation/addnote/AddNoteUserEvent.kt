package com.example.mynotecomposeapplication.data.source.local.entity.presentation.addnote

 sealed class AddNoteUserEvent {
     data class EnteredTitle(val title :String): AddNoteUserEvent()
     data class EnteredDescription(val description :String) : AddNoteUserEvent()
     object SaveNote : AddNoteUserEvent()

 }
