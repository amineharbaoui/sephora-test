package com.example.sephora.presentation.navigation

sealed class Screen(val route: String) {
    object ProductsScreen : Screen("products_screen")
    object ProductDetailsScreen : Screen("details_product_screen")
}