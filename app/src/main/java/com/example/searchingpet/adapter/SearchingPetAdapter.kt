package com.example.searchingpet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchingpet.databinding.ItemPetlistBinding
import com.example.searchingpet.model.Row

class SearchingPetAdapter : ListAdapter<Row, SearchingPetViewHolder>(PetDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchingPetViewHolder {
        return SearchingPetViewHolder(
            ItemPetlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchingPetViewHolder, position: Int) {
        val pet = currentList[position]
        holder.bind(pet)
    }


    companion object {
        private val PetDiffCallback = object : DiffUtil.ItemCallback<Row>() {
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.aNIMALNO == newItem.aNIMALNO
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.aNIMALNO == newItem.aNIMALNO
            }

        }


    }


}