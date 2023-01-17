package ru.seterovas.waynote.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun noteDao(): AppRoomDao

    companion object {
        private var INSTANCE: AppRoomDatabase? = null
        fun getInstance(context: Context): AppRoomDatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context, AppRoomDatabase::class.java, "note.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as AppRoomDatabase
        }
    }
}