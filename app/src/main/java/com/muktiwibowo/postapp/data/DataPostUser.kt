package com.muktiwibowo.postapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 12 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
data class DataPostUser(
    val posts: DataPost,
    val users: DataUser?
): Parcelable