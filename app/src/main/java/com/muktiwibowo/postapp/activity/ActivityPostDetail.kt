package com.muktiwibowo.postapp.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.muktiwibowo.postapp.R
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
                    "%s %s", postDetail?.firstName, postDetail?.lastName
                )
                tvUserPost.text = postDetail?.textContent
                tvDate.text = postDetail?.createdDate
                Glide.with(root.context)
                    .load(postDetail?.profileImagePath)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivUserAvatar)
                Glide.with(root.context)
                    .load(postDetail?.mediaContentPath)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivPostImage)
            }
        }
    }
}