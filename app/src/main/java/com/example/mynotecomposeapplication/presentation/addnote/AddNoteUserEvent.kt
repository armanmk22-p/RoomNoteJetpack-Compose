package com.example.mynotecomposeapplication.presentation.addnote

 sealed class AddNoteUserEvent {
     data class EnteredTitle(val title :String):AddNoteUserEvent()
     data class EnteredDescription(val description :String) :AddNoteUserEvent()
     object SaveNote :AddNoteUserEvent()

 }
