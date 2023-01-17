package ru.seterovas.waynote.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.seterovas.waynote.database.room.AppRoomDatabase
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import ru.seterovas.waynote.database.room.repository.NoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: AppRoomDao): NoteRepository{
        return NoteRepository(noteDao = noteDao)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppRoomDatabase{
        return AppRoomDatabase.getInstance(context = app)
    }

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppRoomDatabase): AppRoomDao{
        return appDatabase.noteDao()
    }
}