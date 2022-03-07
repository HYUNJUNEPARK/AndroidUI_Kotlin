package com.example.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.MainAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Data

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val adapter = MainAdapter()
        adapter.listData = loadData()
        binding.recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
    }

    private fun loadData() : MutableList<Data> {
        val data:MutableList<Data> = mutableListOf()
        for(number in 1..100){
            val title = "Sample $number"
            val date = System.currentTimeMillis()
            var memo = Data(number, title, date)
            data.add(memo)
        }
        return data;
    }
}