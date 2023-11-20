package com.example.searchingpet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.searchingpet.adapter.FragmentPagerAdapter

import com.example.searchingpet.databinding.ActivityMainBinding
import com.example.searchingpet.view.LikeFragment
import com.example.searchingpet.view.ListFragment
import com.example.searchingpet.view.MapFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)




    }
}