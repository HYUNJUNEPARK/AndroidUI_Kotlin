package com.example.viewpager2_tab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpager2_tab.databinding.FragmentABinding

class AFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentABinding.inflate(inflater, container, false)

        //TODO init Function at Here

        return binding.root
    }

}