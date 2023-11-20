package com.example.searchingpet.repository

import com.example.searchingpet.model.GetPetListResponse
import com.example.searchingpet.model.LikeEntity
import retrofit2.Response

interface MainRepository {

    suspend fun getPetList(startIndex : Int, endIndex :Int) : Response<GetPetListResponse>

    suspend fun addLike(likeEntity: LikeEntity)

    suspend fun deleteLike(name: String)

    suspend fun getLikeList() : List<LikeEntity>
}