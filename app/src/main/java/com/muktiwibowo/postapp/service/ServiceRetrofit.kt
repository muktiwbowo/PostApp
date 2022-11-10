package com.muktiwibowo.postapp.service

import com.muktiwibowo.postapp.data.DataUser
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */
fun instance(): API {
    val client = OkHttpClient.Builder()
    return Retrofit.Builder().baseUrl("https://3fc7b134-bc49-4118-a5bc-82472c90a981.mock.pstmn.io/")
        .client(client.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(API::class.java)
}

interface API {
    @GET("users")
    suspend fun getUsers(): Response<List<DataUser>>

    @GET("posts/{page_number}")
    suspend fun getPosts(
        @Path("page_number") pageNumber: String
    ): Response<List<DataUser>>
}