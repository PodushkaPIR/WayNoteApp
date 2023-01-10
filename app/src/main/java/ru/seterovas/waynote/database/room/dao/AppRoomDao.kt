package ru.seterovas.waynote.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM note_table")
    suspend fun getAllNotes()

    @Insert
    suspend fun addNote()

    @Update
    suspend fun updateNote()

    @Delete
    suspend fun deleteNote()

}