package com.example.sephora.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sephora.domain.use_case.ProductUseCase
import com.example.sephora.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productUseCase: ProductUseCase,
) : ViewModel() {

    private val TAG = javaClass.simpleName

    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> = _state

    fun loadProducts() {
        viewModelScope.launch {
            productUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            products = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> _state.value = _state.value.copy(
                        products = result.data ?: emptyList(),
                        isLoading = false
                    )
                }

            }
        }
    }


}