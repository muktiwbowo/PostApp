package com.muktiwibowo.postapp.base

/**
 * Created by Mukti Wibowo on 11 November 2022
 * email: muktiwbowo@gmail.com
 */
sealed class BaseResponse<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = 0
) {
    class Loading<T> : BaseResponse<T>()
    class Success<T>(data: T?) : BaseResponse<T>(data = data)
    class Error<T>(message: String) : BaseResponse<T>(message = message)
}
