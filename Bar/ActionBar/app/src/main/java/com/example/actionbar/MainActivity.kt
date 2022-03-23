package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.actionbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initOpenSubActivityButton()
    }

    private fun initOpenSubActivityButton() {
       binding.openSubActivityButton.setOnClickListener {
           val intent = Intent(this, SubActivity::class.java)
           startActivity(intent)
       }
    }
}