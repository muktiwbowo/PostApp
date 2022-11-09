package com.muktiwibowo.postapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muktiwibowo.postapp.data.DataPost
import com.muktiwibowo.postapp.databinding.HolderPostBinding

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
class AdapterPost : RecyclerView.Adapter<HolderPost>() {
    var posts = mutableListOf<DataPost>()
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
    fun onViewBind(postItem: DataPost) {
        binding.apply {
            /* populate data */
            tvUserName.text = postItem.userName
            tvUserPost.text = postItem.userPost
            tvDate.text = postItem.createdAt

            /* redirect to post detail */
            root.setOnClickListener {
                listenerPost?.onClickPost(postItem)
            }
        }
    }
}

interface ListenerPost {
    fun onClickPost(postItem: DataPost)
}