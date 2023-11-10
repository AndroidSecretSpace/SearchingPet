package com.example.searchingpet.model

sealed class ProgressType {

    object Init :ProgressType()

    object Success : ProgressType()


    object Fail : ProgressType()

    object Loading : ProgressType()

    object Last : ProgressType()


}