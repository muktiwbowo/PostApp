package com.muktiwibowo.postapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 12 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
@Entity(tableName = "tablePostUser")
data class DataPostUser(
    @PrimaryKey
    val id: String,
    var createdDate: String? = "",
    var textContent: String? = "",
    var mediaContentPath: String? = "",
    var tagIds: List<String>? = listOf(),
    var profileImagePath: String,
    var firstName: String,
    var lastName: String
): Parcelable