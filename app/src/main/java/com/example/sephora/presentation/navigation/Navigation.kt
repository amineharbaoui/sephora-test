package com.example.sephora.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sephora.presentation.ProductViewModel
import com.example.sephora.presentation.screens.ProductDetailsScreen
import com.example.sephora.presentation.screens.ProductsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.ProductsScreen.route
    ) {

        composable(route = Screen.ProductsScreen.route) {
            ProductsScreen(
                navController = navController,
                productViewModel = productViewModel
            )
        }

        composable(
            route = Screen.ProductDetailsScreen.route + "?productId={productId}",
            arguments = listOf(
                navArgument(
                    name = "productId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                })
        ) {
            ProductDetailsScreen(
                navController = navController,
                productViewModel = productViewModel,
                it.arguments?.getInt("productId") ?: -1
            )
        }


    }
}