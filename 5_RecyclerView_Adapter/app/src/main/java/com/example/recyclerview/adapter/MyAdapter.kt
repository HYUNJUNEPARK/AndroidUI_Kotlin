package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemMainRecyclerviewBinding
import com.example.recyclerview.model.MyData
import java.text.SimpleDateFormat

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var dataList = mutableListOf<MyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemMainRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    inner class MyHolder(private val binding: ItemMainRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        //TODO 클릭된 아이템의 세부 데이터가 필요할 때 사용
        lateinit var _myData: MyData

        init {
            binding.root.setOnClickListener {
                val number = _myData.number
                val title = _myData.title
                val timestamp = _myData.timestamp
                Toast.makeText(binding.root.context,"ITEM DETAIL : $number / $title / $timestamp ", Toast.LENGTH_LONG).show()
            }
        }
        fun setContents (myData: MyData) {
            _myData = myData
            binding.textNo.text = "${myData.number}"
            binding.textTitle.text = myData.title
            var sdf = SimpleDateFormat("yyyy/MM/dd")
            var formattedDate = sdf.format(myData.timestamp)
            binding.textDate.text = formattedDate
        }
    }

    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
        val data = dataList[position]
        myHolder.setContents(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}