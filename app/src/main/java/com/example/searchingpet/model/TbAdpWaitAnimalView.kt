package com.example.searchingpet.model


import com.google.gson.annotations.SerializedName

data class TbAdpWaitAnimalView(
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    @SerializedName("RESULT")
    val rESULT: RESULT,
    @SerializedName("row")
    val row: List<Row>?
)