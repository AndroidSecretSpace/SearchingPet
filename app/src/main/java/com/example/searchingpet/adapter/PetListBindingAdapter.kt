package com.example.searchingpet.adapter

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
}