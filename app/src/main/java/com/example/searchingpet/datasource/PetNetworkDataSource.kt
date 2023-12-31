package com.example.searchingpet.datasource

import com.example.searchingpet.model.GetPetListResponse
import retrofit2.Response

interface PetNetworkDataSource {

    suspend fun getPetList(startIndex : Int, endIndex :Int) : Response<GetPetListResponse>


}