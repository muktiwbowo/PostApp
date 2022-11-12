package com.muktiwibowo.postapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */
@Parcelize
data class DataUser(
    var id: String,
    var profileImagePath: String,
    var firstName: String,
    var lastName: String
) : Parcelable