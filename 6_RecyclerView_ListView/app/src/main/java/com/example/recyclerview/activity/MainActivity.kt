package com.example.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.MyListAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.MyData

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = MyListAdapter(itemClickedListener = { myData ->
            Toast.makeText(this, "${myData.title}", Toast.LENGTH_SHORT).show()
        })
        adapter.submitList(loadData())
        binding.recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
    }

    private fun loadData() : MutableList<MyData> {
        val dataList:MutableList<MyData> = mutableListOf()
        for(number in 1..100){
            val title = "Sample $number"
            val timestamp = System.currentTimeMillis()
            var info = MyData(number, title, timestamp)
            dataList.add(info)
        }
        return dataList
    }
}