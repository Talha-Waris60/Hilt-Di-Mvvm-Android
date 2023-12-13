package com.devdroiddev.hilt_di.repositories

import android.util.Log
import com.devdroiddev.hilt_di.models.Products
import com.devdroiddev.hilt_di.network.StoreApi
import com.devdroiddev.hilt_di.roomDb.ProductDao
import com.devdroiddev.hilt_di.utils.APP_TAG
import javax.inject.Inject


class ProductRepository @Inject constructor(private val storeApi: StoreApi, private val productDao: ProductDao) {

    suspend fun getProducts(): List<Products> {
        val result = storeApi.getProducts()
        return if (result.isSuccessful && result.body() != null) {
            productDao.insertProduct(result.body()!!)
            result.body()!!
        } else {
            Log.d(APP_TAG, "Error")
            emptyList()
        }
    }

}