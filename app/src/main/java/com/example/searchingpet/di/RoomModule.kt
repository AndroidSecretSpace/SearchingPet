package com.example.searchingpet.di

import android.app.Application
import androidx.room.Room
import com.example.searchingpet.db.Database
import com.example.searchingpet.db.LikeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): Database {
        return Room
            .databaseBuilder(application, Database::class.java, "pet.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: Database): LikeDao = database.likeDao()
}