package com.example.searchingpet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.searchingpet.ListViewModel
import com.example.searchingpet.R
import com.example.searchingpet.adapter.SearchingPetAdapter
import com.example.searchingpet.databinding.FragmentListBinding
import com.example.searchingpet.model.ProgressType
import com.example.searchingpet.toEntity
import com.example.searchingpet.toReview
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    private val viewModel by activityViewModels<ListViewModel>()
    private val searchingPetAdapter = SearchingPetAdapter(
        likeClickEvent = {
        if (it.isLike) viewModel.deleteLike(it.toEntity())
        else viewModel.addLike(it.toEntity())

        }, detailClickEvent = {
            viewModel.setDetailInfo(it)
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }
    )


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
        viewModel.getLikeList()

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

        viewModel.likePetListLiveData.observe(viewLifecycleOwner){
            searchingPetAdapter.submitList(viewModel.searchPetListLiveData.value?.toReview(it))
        }

        viewModel.progressListLiveData.observe(viewLifecycleOwner){
            binding.progressBar.visibility = if (it == ProgressType.Loading) View.VISIBLE
            else View.GONE
        }



    }


}