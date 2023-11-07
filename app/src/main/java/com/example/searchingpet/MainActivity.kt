package com.example.searchingpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.searchingpet.adapter.SearchingPetAdapter
import com.example.searchingpet.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val viewModel  by viewModels<MainViewModel>()
    private val searchingPetAdapter = SearchingPetAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getPetList()

        binding.rvPetList.adapter = searchingPetAdapter

        viewModel.searchPetListLiveData.observe(this){ response ->
            val petList = response.row
            searchingPetAdapter.submitList(petList)
        }



    }
}