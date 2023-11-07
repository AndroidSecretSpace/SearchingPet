package com.example.searchingpet.repository

import com.example.searchingpet.model.GetPetListResponse
import retrofit2.Response

interface MainRepository {

    suspend fun getPetList() : Response<GetPetListResponse>



}