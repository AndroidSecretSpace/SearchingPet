package com.example.searchingpet.repository

import com.example.searchingpet.RetrofitPetNetwork
import com.example.searchingpet.datasource.PetNetworkDataSource
import com.example.searchingpet.model.GetPetListResponse
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val dataSource: RetrofitPetNetwork
) : MainRepository {
    override suspend fun getPetList(): Response<GetPetListResponse> {
        return dataSource.getPetList()
    }
}