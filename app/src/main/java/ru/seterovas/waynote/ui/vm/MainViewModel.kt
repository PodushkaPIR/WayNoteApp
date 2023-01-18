package ru.seterovas.waynote.ui.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.seterovas.waynote.database.room.AppRoomDatabase
import ru.seterovas.waynote.database.room.repository.NoteRepository
import ru.seterovas.waynote.model.NoteModel
import ru.seterovas.waynote.util.REPOSITORY
import ru.seterovas.waynote.util.TYPE_ROOM
import javax.inject.Inject

class MainViewModel(application: Application): AndroidViewModel(application)
{
    val context = application

    fun innitDatabase(type: String, onSuccess: () -> Unit){
        Log.d("checkData", "MainViewModel innitDatabase with type $type")
        when (type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = NoteRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase(
                    {onSuccess()},
                    { Log.d("checkData", "Error: ${it}")}
                )
            }
        }
    }

    fun addNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun updateNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.update(note = note){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun deleteNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(note = note){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun readAllNotes() = REPOSITORY.readAll

    fun signOut(onSuccess: () -> Unit){
        when(DB_TYPE.value){
            TYPE_FIREBASE,
            TYPE_ROOM -> {
                REPOSITORY.signOut()
                onSuccess()
                DB_TYPE.value = Constants.Keys.EMPTY
            }
            else -> { Log.d("checkData", "signOut: ELSE: ${DB_TYPE.value}")}
        }
    }
}


class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
