package ru.seterovas.waynote.database.room.repository

import kotlinx.coroutines.flow.Flow
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.model.NoteModel

class NoteRepository(private val noteDao: AppRoomDao) {

    fun getAllNotes(): Flow<List<NoteModel>> {
        return noteDao.getAllNotes()
    }

    suspend fun insert(note: NoteModel) {
        noteDao.insert(note = note)
    }

    suspend fun update(note: NoteModel) {
        noteDao.update(note = note)
    }

    suspend fun delete(note: NoteModel) {
        noteDao.delete(note = note)
    }
}