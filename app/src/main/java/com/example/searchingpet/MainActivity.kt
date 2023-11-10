package com.example.searchingpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.adapter.SearchingPetAdapter
import com.example.searchingpet.databinding.ActivityMainBinding
import com.example.searchingpet.model.ProgressType
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
        binding.rvPetList.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1)){
                    viewModel.getPetList()
                    Toast.makeText(this@MainActivity,"끝",Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.searchPetListLiveData.observe(this){ row ->
            row?.let{

            searchingPetAdapter.submitList(it)

            }
        }

        viewModel.progressListLiveData.observe(this){
            binding.progressBar.visibility = if (it == ProgressType.Loading) View.VISIBLE
            else View.GONE
        }



    }
}