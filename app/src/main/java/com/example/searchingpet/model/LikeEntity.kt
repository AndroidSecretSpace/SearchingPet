package com.example.searchingpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "like")
data class LikeEntity(
    @PrimaryKey
    val name: String,
    val animalType : String,
    val type : String,
    val time : Long
)
