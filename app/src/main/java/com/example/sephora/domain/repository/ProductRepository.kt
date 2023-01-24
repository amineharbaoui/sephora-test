package com.example.sephora.domain.repository

import com.example.sephora.domain.model.Product
import com.example.sephora.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): Flow<Resource<List<Product>>>

}