package com.devdroiddev.hilt_di.repositories

import android.util.Log
import com.devdroiddev.hilt_di.models.Products
import com.devdroiddev.hilt_di.network.StoreApi
import com.devdroiddev.hilt_di.utils.APP_TAG
import javax.inject.Inject


class ProductRepository @Inject constructor(private val storeApi: StoreApi) {

    suspend fun getProducts(): List<Products> {
        val result = storeApi.getProducts()
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            Log.d(APP_TAG, "Error")
            emptyList()
        }
    }

}