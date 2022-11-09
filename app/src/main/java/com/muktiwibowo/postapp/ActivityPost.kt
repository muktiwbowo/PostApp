package com.muktiwibowo.postapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muktiwibowo.postapp.databinding.ActivityPostBinding

class ActivityPost : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}