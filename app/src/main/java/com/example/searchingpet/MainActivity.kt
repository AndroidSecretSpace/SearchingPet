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
    private lateinit var binding : ActivityMainBinding



    private val tabConfigurationStrategy =
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.icon = resources.obtainTypedArray(R.array.array_main_tab_icon).getDrawable(position)
            tab.text = resources.getStringArray(R.array.array_main_tab_text)[position]
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        val list = listOf(
            ListFragment(),
            MapFragment(),
            LikeFragment(),
        )

        val pageAdapter = FragmentPagerAdapter(list, this)

        with(binding) {
            viewPager.adapter = pageAdapter
            TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy).attach()
        }


    }
}