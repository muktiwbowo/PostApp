package com.muktiwibowo.postapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
data class DataPost(
    var id: String? = "",
    var position: Int? = 0,
    var ownerId: String? = "",
    var createdDate: String? = "",
    var textContent: String? = "",
    var mediaContentPath: String? = "",
    var tagIds: List<String>? = listOf(),
): Parcelable
