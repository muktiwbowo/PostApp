package com.muktiwibowo.postapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 09 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
data class DataPost(
    var userName: String,
    var userAvatar: String,
    var userPost: String,
    var createdAt: String,
    var id: String? = "",
    var position: Int? = 0,
    var ownerId: String? = "",
    var createdDate: String? = "",
    var textContent: String? = "",
    var mediaContentPath: String? = "",
    var tagIds: List<String>? = listOf(),
): Parcelable

val dummyPosts = listOf(
    DataPost(
        userName = "Josephine West",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "10-06-22 01:10"
    ),
    DataPost(
        userName = "Jaden Bridges",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "13-06-22 01:17"
    ),
    DataPost(
        userName = "Emery Cook",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "17-06-22 01:10"
    ),
    DataPost(
        userName = "Richard Hunt",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "22-06-22 01:24"
    ),
    DataPost(
        userName = "Leah Young",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "22-06-22 01:50"
    ),
    DataPost(
        userName = "Michael Blankenship",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "29-06-22 01:45"
    ),
    DataPost(
        userName = "Zachary Hood",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "29-06-22 01:26"
    ),
    DataPost(
        userName = "John Lark",
        userAvatar = "",
        userPost = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The picture is awesome",
        createdAt = "30-06-22 01:22"
    )
)
