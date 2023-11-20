package com.example.searchingpet.adapter

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter

object PetListBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:setName")
    fun setName(view : TextView, name: String){
        view.text = name

    }

    @JvmStatic
    @BindingAdapter("android:setAnimalType")
    fun setAnimalType(view : TextView, type: String){
        view.text = type
    }
    @JvmStatic
    @BindingAdapter("android:setType")
    fun setType(view : TextView, type: String){
        view.text = type

    }

    @JvmStatic
    @BindingAdapter("android:setIsLike")
    fun setIsLike(view : Button, isLike: Boolean){
        view.text = if (isLike) "좋아요 해제"
        else "좋아요"
    }
}