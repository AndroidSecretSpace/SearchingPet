package com.example.searchingpet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchingpet.ListViewModel
import com.example.searchingpet.databinding.ItemPetlistBinding
import com.example.searchingpet.model.ListItem
import com.example.searchingpet.model.Row

class SearchingPetAdapter(private val likeClickEvent: (ListItem) -> Unit) :
    ListAdapter<ListItem, SearchingPetViewHolder>(PetDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchingPetViewHolder {
        return SearchingPetViewHolder(
            ItemPetlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            likeClickEvent = likeClickEvent
        )
    }

    override fun onBindViewHolder(holder: SearchingPetViewHolder, position: Int) {
        val pet = currentList[position]
        holder.bind(pet)

    }


    companion object {
        private val PetDiffCallback = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem.aNIMALNO == newItem.aNIMALNO
            }

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem.aNIMALNO == newItem.aNIMALNO
            }

        }


    }


}