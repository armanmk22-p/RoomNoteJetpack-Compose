package com.example.mynotecomposeapplication.presentation.updatenote

sealed class UpdateNoteUserEvent{

    data class EnteredTitle(val title :String) :UpdateNoteUserEvent()
    data class EnteredDescription(val description :String) :UpdateNoteUserEvent()
    object UpdateNote:UpdateNoteUserEvent()

}
