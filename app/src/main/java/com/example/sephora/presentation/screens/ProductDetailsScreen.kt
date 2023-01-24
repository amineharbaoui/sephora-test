package com.example.sephora.presentation.screens

import ProductContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sephora.presentation.ProductViewModel


@Composable
fun ProductDetailsScreen(
    navController: NavController,
    productViewModel: ProductViewModel = hiltViewModel(),
    productId: Int = -1
) {
    val detailedProduct =
        productViewModel.state.value.products.firstOrNull {
            it.productId == productId
        }
    detailedProduct?.let {
        Box(
            Modifier.fillMaxHeight()
                .background(Color(0xFFEFEFEF))
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                ProductContent(detailedProduct)
            }
        }
    }
}


