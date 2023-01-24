package com.example.sephora.data.remote

import com.example.sephora.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("/items.json")
    suspend fun getProducts(): List<Product>

}