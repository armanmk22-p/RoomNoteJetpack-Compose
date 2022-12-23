package com.example.mynotecomposeapplication.di

import android.content.Context
import androidx.room.Room
import com.example.mynotecomposeapplication.data.source.local.NoteDataBase
import com.example.mynotecomposeapplication.data.source.mapper.NoteMapper
import com.example.mynotecomposeapplication.data.source.repositoryimpl.NoteRepositoryImpl
import com.example.mynotecomposeapplication.domain.repository.NoteRepository
import com.example.mynotecomposeapplication.domain.usecase.*
import com.example.mynotecomposeapplication.util.Constants.Companion.NOTE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBaseInstance(@ApplicationContext context: Context):NoteDataBase{
        return Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            NOTE_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepositoryInstance(dataBase: NoteDataBase):NoteRepository{
        return NoteRepositoryImpl(dataBase.noteDao(), noteMapper = NoteMapper())
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            getAllNotesUseCase = GetAllNotesUseCase(repository),
            getNoteByIdUseCase = GetNoteByIdUseCase(repository),
            insertNoteUseCase = InsertNoteUseCase(repository),
            updateNoteUseCase = UpdateNoteUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideNoteMapperInstance() : NoteMapper{
        return NoteMapper()
    }
}