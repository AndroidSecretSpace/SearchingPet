package com.example.searchingpet.db

import androidx.room.RoomDatabase
import com.example.searchingpet.model.LikeEntity

@androidx.room.Database(
    entities = [
        LikeEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class Database : RoomDatabase() {
    abstract fun likeDao() : LikeDao
}