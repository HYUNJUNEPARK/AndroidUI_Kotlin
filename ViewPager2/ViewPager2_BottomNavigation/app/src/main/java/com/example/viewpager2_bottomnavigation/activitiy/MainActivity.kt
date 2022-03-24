package com.example.viewpager2_bottomnavigation.activitiy

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        initFragment()
        initLinkBottomNaviWithViewPager2()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        menu?.apply {
            findItem(R.id.toolBarMenu1).isVisible = (binding.viewPager.currentItem == 0)
            findItem(R.id.toolBarMenu2).isVisible = (binding.viewPager.currentItem == 1)
            findItem(R.id.toolBarMenu3).isVisible = (binding.viewPager.currentItem == 2)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.toolBarMenu1 -> Toast.makeText(this, "ToolBar Menu 1", Toast.LENGTH_SHORT).show()
            R.id.toolBarMenu2 -> Toast.makeText(this, "ToolBar Menu 2", Toast.LENGTH_SHORT).show()
            R.id.toolBarMenu3 -> Toast.makeText(this, "ToolBar Menu 3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
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
        val toolBarTitleList = listOf(
            getString(R.string.fragment_a),
            getString(R.string.fragment_b),
            getString(R.string.fragment_c)
        )
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menuA -> {
                    binding.viewPager.currentItem = 0
                    binding.titleTextView.text = toolBarTitleList[0]
                    true
                }
                R.id.menuB -> {
                    binding.viewPager.currentItem = 1
                    binding.titleTextView.text = toolBarTitleList[1]
                    true
                }
                R.id.menuC -> {
                    binding.viewPager.currentItem = 2
                    binding.titleTextView.text = toolBarTitleList[2]
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                invalidateOptionsMenu()
                binding.titleTextView.text = toolBarTitleList[position]
                binding.bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }
}