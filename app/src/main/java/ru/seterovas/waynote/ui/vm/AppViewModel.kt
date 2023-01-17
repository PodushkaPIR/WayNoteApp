package ru.seterovas.waynote.ui.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.seterovas.waynote.database.room.repository.NoteRepository
import ru.seterovas.waynote.model.NoteModel
import javax.inject.Inject

interface AppViewModelAbstract {
    val noteListFLow: Flow<List<NoteModel>>
    fun addNote(note: NoteModel)
    fun updateNote(note: NoteModel)
    fun deleteNote(note: NoteModel)
}

@HiltViewModel
class AppViewModel
@Inject constructor(
    private val noteRepository: NoteRepository
    ) : ViewModel(), AppViewModelAbstract{
    override val noteListFLow: Flow<List<NoteModel>> = noteRepository.getAllNotes()

    override fun addNote(note: NoteModel) {
        noteRepository.insert(note = note)
    }

    override fun updateNote(note: NoteModel) {
        noteRepository.update(note = note)
    }

    override fun deleteNote(note: NoteModel) {
        noteRepository.delete(note = note)
    }
}