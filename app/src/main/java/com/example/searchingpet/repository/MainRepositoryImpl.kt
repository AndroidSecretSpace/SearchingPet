package com.example.searchingpet.repository

import com.example.searchingpet.RetrofitPetNetwork
import com.example.searchingpet.datasource.PetNetworkDataSource
import com.example.searchingpet.db.LikeDao
import com.example.searchingpet.model.GetPetListResponse
import com.example.searchingpet.model.LikeEntity
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val dataSource: RetrofitPetNetwork,
    private val dao: LikeDao
) : MainRepository {
    override suspend fun getPetList(startIndex : Int, endIndex :Int): Response<GetPetListResponse> {
        return dataSource.getPetList(startIndex = startIndex, endIndex = endIndex)
    }

    override suspend fun addLike(likeEntity: LikeEntity) {
        dao.addLike(likeEntity)
    }

    override suspend fun deleteLike(name: String) {
        dao.deleteLike(name)
    }

    override suspend fun getLikeList(): List<LikeEntity> = dao.getLikeList()
}