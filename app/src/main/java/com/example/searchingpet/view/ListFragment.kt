package com.example.searchingpet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.ListViewModel
import com.example.searchingpet.R
import com.example.searchingpet.adapter.SearchingPetAdapter
import com.example.searchingpet.databinding.FragmentListBinding
import com.example.searchingpet.model.ProgressType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    private val viewModel by activityViewModels<ListViewModel>()
    private val searchingPetAdapter = SearchingPetAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPetList()


        binding.rvPetList.adapter = searchingPetAdapter
        binding.rvPetList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1)){
                    viewModel.getPetList()

                }
            }
        })

        viewModel.searchPetListLiveData.observe(viewLifecycleOwner){ row ->
            row?.let{

                searchingPetAdapter.submitList(it)

            }
        }

        viewModel.progressListLiveData.observe(viewLifecycleOwner){
            binding.progressBar.visibility = if (it == ProgressType.Loading) View.VISIBLE
            else View.GONE
        }



    }


}