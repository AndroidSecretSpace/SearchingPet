package com.example.searchingpet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.searchingpet.ListViewModel
import com.example.searchingpet.R
import com.example.searchingpet.databinding.FragmentDetailBinding
import com.example.searchingpet.databinding.FragmentLikeBinding


class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private val viewModel by activityViewModels<ListViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)


        initInfo()
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root


    }


    private fun initInfo(){
        binding.name.text = viewModel.getDetailInfo()?.nM ?:"정보를 불러오지 못했습니다"
    }



}