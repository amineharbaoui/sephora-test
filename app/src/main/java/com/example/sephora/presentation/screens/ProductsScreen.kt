package com.example.sephora.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sephora.R
import com.example.sephora.presentation.ProductCard
import com.example.sephora.presentation.ProductViewModel
import com.example.sephora.presentation.navigation.Screen


@Composable
fun ProductsScreen(
    navController: NavController,
    productViewModel: ProductViewModel = hiltViewModel()
) {

    val products = productViewModel.state.value.products
    val state = rememberLazyGridState(
        initialFirstVisibleItemIndex = 0
    )

    if (products.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_list),
                modifier = Modifier
                    .heightIn(160.dp, 260.dp)
                    .fillMaxWidth(),
                contentDescription = ""
            )
            Text(
                text = "No items, Please try again",
                modifier = Modifier.padding(16.dp)
            )
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            Modifier.background(Color(0xFFEFEFEF)),
            state = state,
            content = {
                items(products.size) { i ->
                    ProductCard(
                        product = products[i],
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White)
                            .clickable {
                                navController.navigate(
                                    Screen.ProductDetailsScreen.route + "?productId=${products[i].productId}"
                                )
                            },

                        )
                }
            }
        )
    }


}