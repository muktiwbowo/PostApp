package com.muktiwibowo.postapp.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muktiwibowo.postapp.data.DataPostUser
import com.muktiwibowo.postapp.databinding.ActivityPostDetailBinding

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
class ActivityPostDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onViewBind()
    }

    private fun onViewBind() {
        val postDetail = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("postDetail", DataPostUser::class.java)
        } else {
            intent.getParcelableExtra("postDetail")
        }
        binding.apply {
            parentPost.apply {
                tvUserName.text = String.format(
                    "%s %s", postDetail?.users?.firstName, postDetail?.users?.lastName
                )
                tvUserPost.text = postDetail?.posts?.textContent
                tvDate.text = postDetail?.posts?.createdDate
            }
        }
    }
}