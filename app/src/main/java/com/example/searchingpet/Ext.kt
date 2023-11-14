package com.example.searchingpet

import com.example.searchingpet.model.LikeEntity
import com.example.searchingpet.model.ListItem
import com.example.searchingpet.model.Row

fun ListItem.toEntity() : LikeEntity{

    val timestamp = System.currentTimeMillis()
    return LikeEntity(
        name = this.nM,
        animalType = this.sPCS,
        type = this.bREEDS,
        time = timestamp
    )
}


fun List<Row>.toListItem(likeList : List<LikeEntity>): List<ListItem>{
    return this.map {
        it.toListItem(likeList)

    }
}


fun Row.toListItem(likeList : List<LikeEntity>) : ListItem{
    return ListItem(
        aDPSTTUS,
        aGE,
        aNIMALNO,
        bDWGH,
        bREEDS,
        eNTRNCDATE,
        iNTRCNCN,
        iNTRCNMVPURL,
        nM,
        sEXDSTN,
        sPCS,
        tMPRPRTCCN,
        tMPRPRTCSTTUS,
        isLike = findLike(likeList,this)
    )
}


fun List<LikeEntity>.toListItem(likeList : List<LikeEntity) : List<ListItem>{

    return this.map {
        it.toListItem(likeList)

    }

}


fun LikeEntity.toListItem(likeList : List<LikeEntity>) : ListItem{
    return ListItem(
        aDPSTTUS,
        aGE,
        aNIMALNO,
        bDWGH,
        bREEDS,
        eNTRNCDATE,
        iNTRCNCN,
        iNTRCNMVPURL,
        nM,
        sEXDSTN,
        sPCS,
        tMPRPRTCCN,
        tMPRPRTCSTTUS,
        isLike = findLike(likeList,this)
    )
}


private fun findLike(likeList : List<LikeEntity>,listItem: Row): Boolean{
    likeList.forEach{
        if (it.name == listItem.nM) return true
    }

    return false
}

