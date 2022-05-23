package com.example.recyclerview.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemMainRecyclerviewBinding
import com.example.recyclerview.model.MyData
import java.text.SimpleDateFormat

class MyListAdapter(private val itemClickedListener: (MyData) -> Unit): ListAdapter<MyData, MyListAdapter.MyViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemMainRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class MyViewHolder(private val binding: ItemMainRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MyData) {
            binding.textNo.text = data.number.toString()
            binding.textTitle.text = data.title
            var sdf = SimpleDateFormat("yyyy/MM/dd")
            var formattedDate = sdf.format(data.timestamp)
            binding.textDate.text = formattedDate

            binding.root.setOnClickListener {
                itemClickedListener(data)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MyData>() {
            override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
                return oldItem.number == newItem.number
            }
            override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
                return oldItem == newItem
            }
        }
    }
}