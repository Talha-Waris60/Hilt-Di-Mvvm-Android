package com.devdroiddev.hilt_di.network

import com.devdroiddev.hilt_di.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface StoreApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>

}