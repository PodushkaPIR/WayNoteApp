package ru.seterovas.waynote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.seterovas.waynote.database.room.dao.AppRoomDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: AppRoomDao
    ){
        return
    }
}