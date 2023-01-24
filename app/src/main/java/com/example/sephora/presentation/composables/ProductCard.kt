package com.example.sephora.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sephora.domain.model.Product

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {

        Column(
            Modifier
                .padding(8.dp)
                .background(Color.White)) {

            AsyncImage(
                model = product.imagesUrl.small,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            Text(
                text = product.cBrand.name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
            )

            Text(
                text = product.productName,
                color = Color.DarkGray,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "€${product.price}",
                fontWeight = FontWeight.Bold,
                color = Color(0xff7B1FA2),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}