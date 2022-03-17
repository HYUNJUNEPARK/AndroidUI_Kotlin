package com.example.viewpager2_bottomnavigation.activitiy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2_bottomnavigation.R
import com.example.viewpager2_bottomnavigation.adapter.FragmentAdapter
import com.example.viewpager2_bottomnavigation.databinding.ActivityMainBinding
import com.example.viewpager2_bottomnavigation.fragments.AFragment
import com.example.viewpager2_bottomnavigation.fragments.BFragment
import com.example.viewpager2_bottomnavigation.fragments.CFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragment()
        initLinkBottomNaviWithViewPager2()
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

    private fun initLinkBottomNaviWithViewPager2() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menuA -> {
                    binding.viewPager.currentItem = 0
                    true
                }
                R.id.menuB -> {
                    binding.viewPager.currentItem = 1
                    true
                }
                R.id.menuC -> {
                    binding.viewPager.currentItem = 2
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigation.menu.getItem(position).isChecked = true
                }
            }
        )
    }
}