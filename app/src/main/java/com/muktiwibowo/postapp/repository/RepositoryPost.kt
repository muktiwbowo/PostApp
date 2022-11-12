package com.muktiwibowo.postapp.repository

import com.muktiwibowo.postapp.base.BaseResponse
import com.muktiwibowo.postapp.data.DataPost
import com.muktiwibowo.postapp.data.DataPostUser
import com.muktiwibowo.postapp.data.DataUser
import com.muktiwibowo.postapp.service.API
import com.muktiwibowo.postapp.service.PostUserDao
import javax.inject.Inject

/**
 * Created by Mukti Wibowo on 11 November 2022
 * email: muktiwbowo@gmail.com
 */
class RepositoryPost @Inject constructor(
    private val api: API,
    private val dao: PostUserDao
) {
    suspend fun getUsers(): BaseResponse<List<DataUser>> {
        try {
            val response = api.getUsers()
            val body = response.body()
            if (response.isSuccessful) {
                return if (body != null) BaseResponse.Success(body)
                else BaseResponse.Error(response.message())
            }
            return BaseResponse.Error(response.message())
        } catch (e: Exception) {
            return BaseResponse.Error(e.localizedMessage ?: e.toString())
        }
    }

    suspend fun getPosts(): BaseResponse<List<DataPost>> {
        try {
            val response = api.getPosts("page0")
            val body = response.body()
            if (response.isSuccessful) {
                return if (body != null) BaseResponse.Success(body)
                else BaseResponse.Error(response.message())
            }
            return BaseResponse.Error(response.message())
        } catch (e: Exception) {
            return BaseResponse.Error(e.localizedMessage ?: e.toString())
        }
    }

    suspend fun insertPostUser(items: List<DataPostUser>) = dao.insertPostUser(items)

    fun getPostUser() = dao.getPostUser()
}