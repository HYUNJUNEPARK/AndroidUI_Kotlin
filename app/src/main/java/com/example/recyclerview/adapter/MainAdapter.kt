package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemMainRecyclerviewBinding
import com.example.recyclerview.model.Data
import java.text.SimpleDateFormat

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyHolder>() {
    var listData = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemMainRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    inner class MyHolder(private val binding: ItemMainRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context,"클릭된 아이템=${binding.textTitle.text}", Toast.LENGTH_LONG).show()
            }
        }
        fun setData (data: Data) {
            binding.textNo.text = "${data.no}"
            binding.textTitle.text = data.title
            var sdf = SimpleDateFormat("yyyy/MM/dd")
            var formattedDate = sdf.format(data.timestamp)
            binding.textDate.text = formattedDate
        }
    }

    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
        val data = listData[position]
        myHolder.setData(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}