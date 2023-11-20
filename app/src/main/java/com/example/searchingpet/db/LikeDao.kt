package com.example.searchingpet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.searchingpet.model.LikeEntity

@Dao
interface LikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLike(likeEntity: LikeEntity)

    @Query("DELETE FROM `like` WHERE name = :name")
    suspend fun deleteLike(name: String)

    @Query("SELECT * FROM `like` ORDER BY time DESC")
    suspend fun getLikeList() : List<LikeEntity>
}