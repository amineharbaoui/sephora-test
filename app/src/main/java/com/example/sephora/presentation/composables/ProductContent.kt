import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sephora.domain.model.Product

@Composable
fun ProductContent(product: Product) {
    Column(modifier = Modifier.background(Color.White)) {
        ProductItemsImage(imageUrl = product.imagesUrl.small)
        Divider(
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color(0xFFEEEEEE),
            thickness = 1.dp
        )
        ProductContent(
            brandName = product.cBrand.name,
            productName = product.productName,
            price = product.price
        )
        ProductAbout(description = product.description)
    }
}

@Composable
fun ProductContent(brandName: String, productName: String, price: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Column() {
            Text(
                text = brandName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xff222325),
            )
            Text(
                text = productName,
                fontSize = 15.sp,
                color = Color.Gray,
            )
            Text(
                text = "€$price",
                fontSize = 22.sp,
                color = Color(0xff7B1FA2),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }


    }
}


@Composable
fun ProductItemsImage(imageUrl: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {

            AsyncImage(
                model = imageUrl,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun ProductAbout(description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = description,
                fontSize = 18.sp,
                color = Color.Gray,
            )
        }
    }
}