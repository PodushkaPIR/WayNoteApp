package ru.seterovas.waynote.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.seterovas.waynote.model.NoteModel

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Insert
    fun insert(note: NoteModel)

    @Update
    fun update(note: NoteModel)

    @Delete
    fun delete(note: NoteModel)

}