package com.example.searchingpet.model


import com.google.gson.annotations.SerializedName

data class ListItem(
    val aDPSTTUS: String,
    val aGE: String,
    val aNIMALNO: Double,
    val bDWGH: Double,
    val bREEDS: String,
    val eNTRNCDATE: String,
    val iNTRCNCN: String,
    val iNTRCNMVPURL: String,
    val nM: String,
    val sEXDSTN: String,
    val sPCS: String,
    val tMPRPRTCCN: String,
    val tMPRPRTCSTTUS: String,
    var isLike: Boolean
)