package ru.seterovas.waynote.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.seterovas.waynote.model.NoteModel

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Insert
    suspend fun addNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)

}