package com.example.mynotecomposeapplication.presentation.listnote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotecomposeapplication.domain.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListNoteViewModel @Inject constructor(private val getAllNotesUseCase: GetAllNotesUseCase):ViewModel() {


    private val _listNote= mutableStateOf(ListNoteUiState())
    val listNote: State<ListNoteUiState> = _listNote

    private val _eventFlow = MutableSharedFlow<ListNoteUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        getAllNotes()
    }

    fun onEvent(event :ListNoteUserEvent){
        when(event){
            is ListNoteUserEvent.AddNote ->{
                //navigate to addNote Screen
            }
        }
    }

    private fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                getAllNotesUseCase.invoke().onEach {
                    _listNote.value = listNote.value.copy(
                        notes = it
                    )
                }
            }catch (e :Exception){
                _eventFlow.emit(ListNoteUiEvent.ShowSnackBar(
                    message = e.localizedMessage?:"Unknown Error"
                ))
            }
        }
    }


}