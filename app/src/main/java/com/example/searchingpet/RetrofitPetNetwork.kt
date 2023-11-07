package com.example.searchingpet

import com.example.searchingpet.datasource.PetNetworkDataSource
import com.example.searchingpet.model.GetPetListResponse
import okhttp3.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject


private interface RetrofitPetNetworkApi {


    @GET("/{key}/{type}/{service}/{startIndex}/{endIndex}")
    suspend fun getPetList(
        @Path(value = "key") key: String = "53456c65666b736931303474756a456c",
        @Path(value = "type") type: String = "json",
        @Path(value = "service") service: String = "TbAdpWaitAnimalView",
        @Path(value = "startIndex") startIndex: Int = 1,
        @Path(value = "endIndex") endIndex: Int = 5


    ) : Response<GetPetListResponse>

}

class RetrofitPetNetwork @Inject constructor(
    okHttpCallFactory: Call.Factory
) : PetNetworkDataSource{
    private val petNetworkApi = Retrofit.Builder()
        .baseUrl("http://openapi.seoul.go.kr:8088")
        .callFactory(okHttpCallFactory)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitPetNetworkApi::class.java)

    override suspend fun getPetList(): Response<GetPetListResponse> {
        return petNetworkApi.getPetList()
    }

}