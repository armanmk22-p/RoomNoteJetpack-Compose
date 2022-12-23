package com.example.mynotecomposeapplication.presentation.updatenote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotecomposeapplication.domain.model.Note
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import com.example.mynotecomposeapplication.domain.usecase.GetNoteByIdUseCase
import com.example.mynotecomposeapplication.domain.usecase.InsertNoteUseCase
import com.example.mynotecomposeapplication.domain.usecase.UpdateNoteUseCase
import com.example.mynotecomposeapplication.presentation.addnote.AddNoteUiEvent
import com.example.mynotecomposeapplication.presentation.addnote.AddNoteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _updateNote = mutableStateOf(UpdateNoteUiState())
    val updateNote: State<UpdateNoteUiState> = _updateNote

    private val _eventFlow = MutableSharedFlow<UpdateNoteUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var noteId: Int? = null

    init {

        savedStateHandle.get<Int>("id")?.let {
            viewModelScope.launch(Dispatchers.IO) {
                getNoteByIdUseCase.invoke(it).collect {
                    noteId = it.id
                    _updateNote.value = updateNote.value.copy(
                        title = it.title,
                        description = it.description
                    )
                }
            }
        }
    }

    fun onEvent(event: UpdateNoteUserEvent) {
        when (event) {

            is UpdateNoteUserEvent.EnteredTitle -> {
                _updateNote.value = updateNote.value.copy(
                    title = event.title
                )
            }

            is UpdateNoteUserEvent.EnteredDescription -> {
                _updateNote.value = updateNote.value.copy(
                    description = event.description
                )
            }

            is UpdateNoteUserEvent -> {

                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        updateNoteUseCase.invoke(
                            Note(
                                id = noteId,
                                title = updateNote.value.title,
                                description = updateNote.value.description
                            )
                        )

                        _eventFlow.emit(
                            UpdateNoteUiEvent.ShowSnackBar(
                                message = "NoteUpdated Successfully"
                            )
                        )
                    } catch (e: Exception) {

                        _eventFlow.emit(
                            UpdateNoteUiEvent.ShowSnackBar(
                                message = e.localizedMessage ?: "Unknown Error"
                            )
                        )
                    }

                }
            }
        }
    }


}