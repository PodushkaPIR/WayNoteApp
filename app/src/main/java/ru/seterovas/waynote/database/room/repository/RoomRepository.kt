package ru.seterovas.waynote.database.room.repository

import kotlinx.coroutines.flow.Flow
import ru.seterovas.waynote.database.DatabaseRepository
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.model.NoteModel

class RoomRepository(private val noteRoomDao: AppRoomDao) : DatabaseRepository {

    fun getAllNotes(): Flow<List<NoteModel>> {
        return noteRoomDao.getAllNotes()
    }

    fun addNote(note: NoteModel) {
        noteRoomDao.addNote(note = note)
    }

    fun updateNote(note: NoteModel) {
        noteRoomDao.updateNote(note = note)
    }

    fun deleteNote(note: NoteModel) {
        noteRoomDao.deleteNote(note = note)
    }
}