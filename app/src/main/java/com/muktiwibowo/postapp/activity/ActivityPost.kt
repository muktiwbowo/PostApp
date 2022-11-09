package com.muktiwibowo.postapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muktiwibowo.postapp.adapter.AdapterPost
import com.muktiwibowo.postapp.adapter.ListenerPost
import com.muktiwibowo.postapp.data.DataPost
import com.muktiwibowo.postapp.data.dummyPosts
import com.muktiwibowo.postapp.databinding.ActivityPostBinding

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
class ActivityPost : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private lateinit var adapterPost: AdapterPost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onViewBind()
        onViewNavigate()
    }

    private fun onViewBind() {
        /*initialize adapter*/
        adapterPost = AdapterPost()
        binding.rvPost.adapter = adapterPost

        /*load data*/
        adapterPost.posts.clear()
        adapterPost.posts.addAll(dummyPosts)
        adapterPost.notifyItemRangeChanged(0, adapterPost.itemCount)
    }

    private fun onViewNavigate() {
        adapterPost.listenerPost = object : ListenerPost {
            override fun onClickPost(index: Int, postItem: DataPost) {
                /* redirect to post detail */
                startActivity(Intent(this@ActivityPost, ActivityPostDetail::class.java).apply {
                    putExtra("index", index)
                })
            }
        }
    }
}