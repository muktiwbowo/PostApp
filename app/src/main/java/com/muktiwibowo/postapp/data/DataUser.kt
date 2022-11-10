package com.muktiwibowo.postapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */
@Entity(tableName = "users")
data class DataUser(
    @PrimaryKey
    var id: String,
    var profileImagePath: String,
    var firstName: String,
    var lastName: String
)