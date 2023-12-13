package com.devdroiddev.hilt_di.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devdroiddev.hilt_di.models.Products

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product : List<Products>)

    @Query("SELECT * FROM Products")
    fun getProducts() : LiveData<List<Products>>

}