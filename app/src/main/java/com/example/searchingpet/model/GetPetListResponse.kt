package com.example.searchingpet.model


import com.google.gson.annotations.SerializedName

data class GetPetListResponse(
    @SerializedName("TbAdpWaitAnimalView")
    val tbAdpWaitAnimalView: TbAdpWaitAnimalView?
)