package com.example.mynotecomposeapplication.data.source.local.entity.presentation.navigation

import com.example.mynotecomposeapplication.util.Constants.Companion.LIST_NOTE_SCREEN
import com.example.mynotecomposeapplication.util.Constants.Companion.UPDATE_NOTE_SCREEN


sealed class Screen(val route: String) {
    object ListNoteScreen: Screen(LIST_NOTE_SCREEN)
    object UpdateNoteScreen: Screen(UPDATE_NOTE_SCREEN)
}