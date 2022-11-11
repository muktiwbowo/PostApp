package com.muktiwibowo.postapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muktiwibowo.postapp.base.BaseResponse
import com.muktiwibowo.postapp.data.DataUser
import com.muktiwibowo.postapp.repository.RepositoryPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
    val getUsers = MutableLiveData<BaseResponse<List<DataUser>>>()
    fun getUsers() {
        viewModelScope.launch {
            getUsers.value = BaseResponse.Loading()
            val response = repositoryPost.getUsers()
            withContext(Dispatchers.Main) {
                if (response is BaseResponse.Success) {
                    getUsers.value = BaseResponse.Success(data = response.data)
                } else if (response is BaseResponse.Error) {
                    getUsers.value =
                        BaseResponse.Error(message = response.message ?: "Something went wrong")
                }
            }
        }
    }
}