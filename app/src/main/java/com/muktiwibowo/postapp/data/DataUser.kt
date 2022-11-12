package com.muktiwibowo.postapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
@Entity(tableName = "users")
data class DataUser(
    @PrimaryKey
    var id: String,
    var profileImagePath: String,
    var firstName: String,
    var lastName: String
): Parcelable