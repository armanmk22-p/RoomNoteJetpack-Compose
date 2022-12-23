package com.example.mynotecomposeapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynotecomposeapplication.data.source.local.entity.NoteEntity



@Database(entities = [NoteEntity::class], version = 1 , exportSchema = false)
abstract class NoteDataBase :RoomDatabase(){

    abstract fun noteDao(): NoteDao
}