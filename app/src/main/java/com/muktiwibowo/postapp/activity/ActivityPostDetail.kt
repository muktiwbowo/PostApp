package com.muktiwibowo.postapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muktiwibowo.postapp.data.DataPost
import com.muktiwibowo.postapp.data.dummyPosts
import com.muktiwibowo.postapp.databinding.ActivityPostDetailBinding

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
class ActivityPostDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailBinding
    private var postItem: DataPost? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onViewBind()
    }

    private fun onViewBind() {
        val index = intent.getIntExtra("index", 0)
        postItem = dummyPosts[index]
        binding.apply {
            parentPost.apply {
                postItem?.let { item ->
                    tvUserName.text = item.userName
                    tvUserPost.text = item.userPost
                    tvDate.text = item.createdAt
                }
            }
        }
    }
}