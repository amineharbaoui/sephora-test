package com.example.sephora.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sephora.presentation.navigation.Navigation
import com.example.sephora.presentation.ui.theme.SEPHORATESTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productViewModel.loadProducts()

        setContent {
            SEPHORATESTTheme {
                Navigation()
            }
        }
    }
}

