package com.example.searchingpet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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




    private val _searchPetListLiveData = MutableLiveData<TbAdpWaitAnimalView>()
    val searchPetListLiveData: LiveData<TbAdpWaitAnimalView> = _searchPetListLiveData

    fun getPetList() = viewModelScope.launch{
        val response = mainRepository.getPetList()


        if (response.isSuccessful){
            response.body()?.let { body ->
                _searchPetListLiveData.value = body.tbAdpWaitAnimalView
                Log.d("ddd","${response.body()}")
            }


        }


    }






}