package com.muktiwibowo.postapp.service

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muktiwibowo.postapp.data.DataUser

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */

@Database(entities = [DataUser::class], version = 1)
abstract class ServiceRoom : RoomDatabase() {
    abstract fun userDao(): UserDao

    fun instance(context: Context) =
        Room.databaseBuilder(
            context,
            ServiceRoom::class.java,
            "db_post"
        ).build()
}

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): List<DataUser>

    @Insert
    fun insertUsers(vararg list: List<DataUser>)
}