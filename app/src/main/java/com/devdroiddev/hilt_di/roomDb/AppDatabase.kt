package com.devdroiddev.hilt_di.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devdroiddev.hilt_di.models.Products


@Database(entities = [Products::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao
}