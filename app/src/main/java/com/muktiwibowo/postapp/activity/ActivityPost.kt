package com.muktiwibowo.postapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.muktiwibowo.postapp.adapter.AdapterPost
import com.muktiwibowo.postapp.adapter.ListenerPost
import com.muktiwibowo.postapp.base.BaseResponse
import com.muktiwibowo.postapp.data.DataPostUser
import com.muktiwibowo.postapp.databinding.ActivityPostBinding
import com.muktiwibowo.postapp.viewmodel.ViewModelPost
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
@AndroidEntryPoint
class ActivityPost : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private lateinit var adapterPost: AdapterPost
    private val viewModelPost by viewModels<ViewModelPost>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onViewBind()
        onViewNavigate()
        onViewObserve()
    }

    private fun onViewBind() {
        /*initialize adapter*/
        adapterPost = AdapterPost()
        binding.rvPost.adapter = adapterPost

        /* call api */
        viewModelPost.getUsers()
    }

    private fun onViewNavigate() {
        adapterPost.listenerPost = object : ListenerPost {
            override fun onClickPost(index: Int, postItem: DataPostUser) {
                /* redirect to post detail */
                startActivity(Intent(this@ActivityPost, ActivityPostDetail::class.java).apply {
                    putExtra("postDetail", postItem)
                })
            }
        }
    }

    private fun onViewObserve() {
        /* observe data from api */
        viewModelPost.getPosts.observe(this) { response ->
            when (response) {
                is BaseResponse.Loading -> {
                    /* show loading state */

                }
                is BaseResponse.Success -> {
                    val listPost = response.data
                    /*load data*/
                    listPost?.let { items ->
                        adapterPost.apply {
                            posts.clear()
                            posts.addAll(items)
                            notifyItemRangeChanged(0, itemCount)
                        }
                    }
                }
                is BaseResponse.Error -> {
                    /* show error message from api with toast */
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}