package ru.seterovas.waynote.util

import androidx.compose.runtime.mutableStateOf
import ru.seterovas.waynote.database.DatabaseRepository


const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"

lateinit var REPOSITORY : DatabaseRepository
lateinit var EMAIL : String
lateinit var PASSWORD : String
var DB_TYPE = mutableStateOf("")


class Constants {

    object Screens{
        const val HOME = "home_screen"
        const val ADD = "add_screen"
        const val DETAIL = "detail_screen"
    }
}