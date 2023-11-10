package com.example.searchingpet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchingpet.model.ProgressType
import com.example.searchingpet.model.Row
import com.example.searchingpet.model.TbAdpWaitAnimalView
import com.example.searchingpet.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val criteria = 10
    private var offset = 1
    private val savePetList = mutableListOf<Row>()


    private val _searchPetListLiveData = MutableLiveData<List<Row>>()
    val searchPetListLiveData: LiveData<List<Row>> = _searchPetListLiveData


    private val _progressLiveData = MutableLiveData<ProgressType>()
    val progressListLiveData: LiveData<ProgressType> = _progressLiveData


    init {
        _progressLiveData.value = ProgressType.Init
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
                        val list = mutableListOf<Row>()
                        list.addAll(savePetList)
                        list.addAll(row)
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


}






