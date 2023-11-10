package com.example.searchingpet.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.databinding.ItemPetlistBinding
import com.example.searchingpet.model.Row

class SearchingPetViewHolder(private val binding: ItemPetlistBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Row) {
        binding.data = item

    }




}