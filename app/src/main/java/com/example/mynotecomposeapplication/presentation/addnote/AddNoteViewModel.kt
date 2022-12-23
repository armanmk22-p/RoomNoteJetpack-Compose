package com.example.mynotecomposeapplication.presentation.addnote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import com.example.mynotecomposeapplication.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val insertNoteUseCase: InsertNoteUseCase) :ViewModel() {

    private val _addNote= mutableStateOf(AddNoteUiState())
    val addNote: State<AddNoteUiState> = _addNote

    private val _eventFlow = MutableSharedFlow<AddNoteUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


            fun onEvent(event :AddNoteUserEvent){
                when(event){

                    is AddNoteUserEvent.EnteredTitle ->{
                        _addNote.value = addNote.value.copy(
                            title = event.title
                        )
                    }

                    is AddNoteUserEvent.EnteredDescription ->{
                        _addNote.value = addNote.value.copy(
                            description = event.description
                        )
                    }

                    is AddNoteUserEvent.SaveNote ->{
                        viewModelScope.launch(Dispatchers.IO){

                            try {
                              insertNoteUseCase.invoke(
                                    Note(
                                        id = 0,
                                        title = addNote.value.title,
                                        description = addNote.value.description
                                    )
                                )
                                _eventFlow.emit(AddNoteUiEvent.ShowSnackBar(
                                    message = "Note Saved Successfully"
                                ))
                            }catch (e:Exception){
                                _eventFlow.emit(AddNoteUiEvent.ShowSnackBar(
                                    message = e.localizedMessage?:"Unknown Exception"
                                ))
                            }

                        }

                    }
                }
            }


}