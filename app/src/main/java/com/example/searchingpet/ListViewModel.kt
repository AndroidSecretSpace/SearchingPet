package com.example.searchingpet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchingpet.model.LikeEntity
import com.example.searchingpet.model.ListItem
import com.example.searchingpet.model.ProgressType
import com.example.searchingpet.model.Row
import com.example.searchingpet.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val criteria = 10
    private var offset = 1
    private var savePetList = mutableListOf<ListItem>()


    private val _searchPetListLiveData = MutableLiveData<List<ListItem>>()
    val searchPetListLiveData: LiveData<List<ListItem>> = _searchPetListLiveData


    private val _progressLiveData = MutableLiveData<ProgressType>()
    val progressListLiveData: LiveData<ProgressType> = _progressLiveData

    private val _likePetListLiveData = MutableLiveData<List<LikeEntity>>()
    val likePetListLiveData: LiveData<List<LikeEntity>> = _likePetListLiveData


    private lateinit var detailInfo: ListItem


    init {
        _progressLiveData.value = ProgressType.Init
    }


    fun setDetailInfo(info: ListItem) {
        detailInfo = info
    }

    fun getDetailInfo(): ListItem? {
        return if (::detailInfo.isInitialized) detailInfo
        else null
    }

    fun getPetList() = viewModelScope.launch {
        if (progressListLiveData.value != ProgressType.Loading && progressListLiveData.value != ProgressType.Last) {
            _progressLiveData.value = ProgressType.Loading

            val startIndex = offset
            val endIndex = offset + criteria - 1
            offset = endIndex
            val response = mainRepository.getPetList(startIndex = startIndex, endIndex = endIndex)


            if (response.isSuccessful) {
                response.let {
                    it.body()?.tbAdpWaitAnimalView?.row?.let { row ->
                        val list = mutableListOf<ListItem>()
                        list.addAll(savePetList)
                        if (likePetListLiveData.value != null) list.addAll(
                            row.toListItem(
                                likePetListLiveData.value!!
                            )
                        )
                        _searchPetListLiveData.value = list
                        savePetList.addAll(list)
                        _progressLiveData.value = ProgressType.Success

                        if (row.size < criteria) _progressLiveData.value = ProgressType.Last
                        else _progressLiveData.value = ProgressType.Success

                    } ?: kotlin.run {
                        _progressLiveData.value = ProgressType.Fail
                    }


                }
            } else _progressLiveData.value = ProgressType.Fail


        }
    }

    fun addLike(likeEntity: LikeEntity) = viewModelScope.launch {
        mainRepository.addLike(likeEntity)

        getLikeList()
    }

    fun deleteLike(likeEntity: LikeEntity) = viewModelScope.launch {
        mainRepository.deleteLike(likeEntity.name)

        getLikeList()
    }

    fun getLikeList() = viewModelScope.launch {
        _likePetListLiveData.value = mainRepository.getLikeList()
    }
}






