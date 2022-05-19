package com.june.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.june.fragment.databinding.ActivityMainBinding
import com.june.fragment.fragments.ChatFragment
import com.june.fragment.fragments.HomeFragment
import com.june.fragment.fragments.MyInfoFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        val fragmentList = arrayListOf(
            HomeFragment(),
            ChatFragment(),
            MyInfoFragment()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(fragmentList[0])
        initFragment()
    }

    private fun initFragment(){
        binding.bottomNavigationView.setOnItemSelectedListener{ menu ->
            when (menu.itemId) {
                R.id.home -> replaceFragment(fragmentList[0])
                R.id.chatList -> replaceFragment(fragmentList[1])
                R.id.myPage -> replaceFragment(fragmentList[2])
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }


}