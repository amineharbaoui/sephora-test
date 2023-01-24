package com.example.sephora.presentation

import com.example.sephora.domain.model.Product

data class ProductState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false
)