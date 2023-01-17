package ru.seterovas.waynote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteModel(

    @PrimaryKey(autoGenerate = true)
    val roomId: Long ?= null,

    @ColumnInfo
    val title: String
)