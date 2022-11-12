package com.muktiwibowo.postapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muktiwibowo.postapp.R
import com.muktiwibowo.postapp.data.DataPostUser
import com.muktiwibowo.postapp.databinding.HolderPostBinding

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
class AdapterPost : RecyclerView.Adapter<HolderPost>() {
    var posts = mutableListOf<DataPostUser>()
    var listenerPost: ListenerPost? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPost {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderPostBinding.inflate(inflater, parent, false)
        return HolderPost(binding, listenerPost)
    }

    override fun onBindViewHolder(holder: HolderPost, position: Int) {
        holder.onViewBind(posts[position])
    }

    override fun getItemCount() = posts.size
}

class HolderPost(private val binding: HolderPostBinding, private val listenerPost: ListenerPost?) :
    RecyclerView.ViewHolder(binding.root) {
    fun onViewBind(postItem: DataPostUser) {
        binding.apply {
            /* populate data */
            tvUserName.text = String.format(
                "%s %s", postItem.firstName, postItem.lastName
            )
            tvUserPost.text = postItem.textContent
            tvDate.text = postItem.createdDate
            Glide.with(root.context)
                .load(postItem.profileImagePath)
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivUserAvatar)

            /* redirect to post detail */
            root.setOnClickListener {
                listenerPost?.onClickPost(adapterPosition, postItem)
            }
        }
    }
}

interface ListenerPost {
    fun onClickPost(index: Int, postItem: DataPostUser)
}