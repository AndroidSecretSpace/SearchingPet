package com.example.searchingpet.model


import com.google.gson.annotations.SerializedName

data class Row(
    @SerializedName("ADP_STTUS")
    val aDPSTTUS: String,
    @SerializedName("AGE")
    val aGE: String,
    @SerializedName("ANIMAL_NO")
    val aNIMALNO: Double,
    @SerializedName("BDWGH")
    val bDWGH: Double,
    @SerializedName("BREEDS")
    val bREEDS: String,
    @SerializedName("ENTRNC_DATE")
    val eNTRNCDATE: String,
    @SerializedName("INTRCN_CN")
    val iNTRCNCN: String,
    @SerializedName("INTRCN_MVP_URL")
    val iNTRCNMVPURL: String,
    @SerializedName("NM")
    val nM: String,
    @SerializedName("SEXDSTN")
    val sEXDSTN: String,
    @SerializedName("SPCS")
    val sPCS: String,
    @SerializedName("TMPR_PRTC_CN")
    val tMPRPRTCCN: String,
    @SerializedName("TMPR_PRTC_STTUS")
    val tMPRPRTCSTTUS: String
)