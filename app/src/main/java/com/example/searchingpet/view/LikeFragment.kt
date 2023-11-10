package com.example.searchingpet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.searchingpet.R
import com.example.searchingpet.databinding.FragmentLikeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LikeFragment : Fragment() {
    private lateinit var binding : FragmentLikeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_like, container, false)
        return binding.root
    }


}