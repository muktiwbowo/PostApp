package com.muktiwibowo.postapp.service

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.muktiwibowo.postapp.data.DataPostUser

/**
 * Created by Mukti Wibowo on 10 November 2022
 * email: muktiwbowo@gmail.com
 */

@Database(entities = [DataPostUser::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ServiceRoom : RoomDatabase() {
    abstract fun postUserDao(): PostUserDao

    companion object {
        fun instance(context: Context) =
            Room.databaseBuilder(
                context,
                ServiceRoom::class.java,
                "db_post"
            ).build()
    }

}

@Dao
interface PostUserDao {
    @Query("SELECT * FROM tablePostUser")
    fun getPostUser(): LiveData<List<DataPostUser>>

    @Insert(onConflict = REPLACE)
    suspend fun insertPostUser(items: List<DataPostUser>)
}

class Converter {
    @TypeConverter
    fun fromStringList(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return try {
            Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
        } catch (e: Exception) {
            listOf()
        }
    }
}