package ru.seterovas.waynote.database.room.repository

import kotlinx.coroutines.flow.Flow
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.model.NoteModel

class RoomRepository(private val noteRoomDao: AppRoomDao) {

    fun getAllNotes(): Flow<List<NoteModel>> {
        return noteRoomDao.getAllNotes()
    }

    fun insert(note: NoteModel) {
        noteRoomDao.insert(note = note)
    }

    fun update(note: NoteModel) {
        noteRoomDao.update(note = note)
    }

    fun delete(note: NoteModel) {
        noteRoomDao.delete(note = note)
    }
}