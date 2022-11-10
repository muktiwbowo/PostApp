package com.muktiwibowo.postapp.base

import android.content.Context
import com.muktiwibowo.postapp.service.API
import com.muktiwibowo.postapp.service.ServiceRoom
import com.muktiwibowo.postapp.service.instance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class BaseModule {
    @Provides
    fun providesRetrofit(): API = instance()

    @Provides
    fun providesRoom(context: Context): ServiceRoom = ServiceRoom.instance(context)
}