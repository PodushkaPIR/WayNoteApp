package ru.seterovas.waynote.database

import androidx.lifecycle.LiveData
import ru.seterovas.waynote.model.NoteModel

interface DatabaseRepository {

    val readAll: LiveData<List<NoteModel>>
    suspend fun create(note: NoteModel, onSuccess: () -> Unit)

    suspend fun update(note: NoteModel, onSuccess: () -> Unit)

    suspend fun delete(note: NoteModel, onSuccess: () -> Unit)

    fun signOut(){}

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}
}