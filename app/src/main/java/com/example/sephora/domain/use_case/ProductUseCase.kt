package com.example.sephora.domain.use_case

import com.example.sephora.domain.model.Product
import com.example.sephora.domain.repository.ProductRepository
import com.example.sephora.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Product>>> = productRepository.getProducts()

}