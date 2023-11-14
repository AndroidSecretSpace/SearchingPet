package com.example.searchingpet.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.databinding.ItemPetlistBinding
import com.example.searchingpet.model.ListItem
import com.example.searchingpet.model.Row

class SearchingPetViewHolder(private val binding: ItemPetlistBinding,
    private val likeClickEvent:(ListItem) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: ListItem) {
        binding.data = item

        binding.likeBtn.setOnClickListener {
            likeClickEvent.invoke(item)
        }

    }




}