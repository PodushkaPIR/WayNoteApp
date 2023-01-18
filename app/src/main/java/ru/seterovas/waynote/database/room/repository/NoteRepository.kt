package ru.seterovas.waynote.database.room.repository

import androidx.lifecycle.LiveData
import ru.seterovas.waynote.database.DatabaseRepository
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.model.NoteModel

class NoteRepository(private val noteRoomDao: AppRoomDao): DatabaseRepository {

    override val readAll: LiveData<List<NoteModel>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: NoteModel, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: NoteModel, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: NoteModel, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
        onSuccess()
    }

    override fun signOut() {}
}