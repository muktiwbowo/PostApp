package com.muktiwibowo.postapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muktiwibowo.postapp.base.BaseResponse
import com.muktiwibowo.postapp.data.DataPost
import com.muktiwibowo.postapp.data.DataPostUser
import com.muktiwibowo.postapp.data.DataUser
import com.muktiwibowo.postapp.repository.RepositoryPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Mukti Wibowo on 11 November 2022
 * email: muktiwbowo@gmail.com
 */
@HiltViewModel
class ViewModelPost @Inject constructor(
    private val repositoryPost: RepositoryPost
) : ViewModel() {
    val getPosts = MutableLiveData<BaseResponse<List<DataPostUser>>>()
    fun getPosts() {
        viewModelScope.launch {
            getPosts.value = BaseResponse.Loading()
            val jobUser = async { repositoryPost.getUsers() }
            val jobPost = async { repositoryPost.getPosts() }
            val users = jobUser.await()
            val posts = jobPost.await()
            withContext(Dispatchers.Main) {
                if (users is BaseResponse.Success && posts is BaseResponse.Success) {
                    val results = filterPostUser(
                        posts = posts.data,
                        users = users.data
                    ).apply {
                        insertPostUser(this)
                    }
                    getPosts.value = BaseResponse.Success(
                        data = results
                    )
                } else if (posts is BaseResponse.Error) {
                    getPosts.value =
                        BaseResponse.Error(message = posts.message ?: "Something went wrong")
                } else if (users is BaseResponse.Error) {
                    getPosts.value =
                        BaseResponse.Error(message = users.message ?: "Something went wrong")
                }
            }
        }
    }

    private fun filterPostUser(posts: List<DataPost>?, users: List<DataUser>?): List<DataPostUser> {
        val result = posts?.map { post ->
            val user = users?.filter { it.id == post.ownerId }?.get(0)
            DataPostUser(
                id = post.id ?: "",
                createdDate = post.createdDate,
                textContent = post.textContent,
                mediaContentPath = post.mediaContentPath,
                tagIds = post.tagIds,
                profileImagePath = user?.profileImagePath ?: "",
                firstName = user?.firstName ?: "",
                lastName = user?.lastName ?: "",
            )
        }
        return if (!result.isNullOrEmpty()) result else listOf()
    }

    private fun insertPostUser(items: List<DataPostUser>) {
        viewModelScope.launch {
            repositoryPost.insertPostUser(items)
        }
    }

    fun getPostUser() = repositoryPost.getPostUser()
}