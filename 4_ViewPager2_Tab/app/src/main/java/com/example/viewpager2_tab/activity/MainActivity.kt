package com.example.viewpager2_tab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager2_tab.R
import com.example.viewpager2_tab.adapter.FragmentAdapter
import com.example.viewpager2_tab.databinding.ActivityMainBinding
import com.example.viewpager2_tab.fragment.AFragment
import com.example.viewpager2_tab.fragment.BFragment
import com.example.viewpager2_tab.fragment.CFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragment()
        initTab()
    }

    private fun initFragment() {
        val fragmentList = listOf(
            AFragment(),
            BFragment(),
            CFragment()
        )
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter
    }

    private fun initTab() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { /*tab*/_, /*position*/_ ->

        }.attach()
        binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_person_vector)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_star_vector)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_clock_vector)
    }
}