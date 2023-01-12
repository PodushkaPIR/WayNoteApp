package ru.seterovas.waynote.database


interface DatabaseRepository {

    suspend fun getAllNotes()

    suspend fun addNote()

    suspend fun updateNote()

    suspend fun deleteNote()
}