package ru.seterovas.waynote.database.room

import androidx.room.Database
import ru.seterovas.waynote.model.AppModel

@Database(entities = [AppModel::class], version = 1)
abstract class AppRoomDatabase {
}