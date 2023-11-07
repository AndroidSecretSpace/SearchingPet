package com.example.searchingpet.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.databinding.ItemPetlistBinding
import com.example.searchingpet.model.Row

class SearchingPetViewHolder(private val binding: ItemPetlistBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Row) {
        binding.tvName.text = item.nM
        binding.tvKind.text = item.sPCS
        binding.tvSpecies.text = item.bREEDS




    }




}