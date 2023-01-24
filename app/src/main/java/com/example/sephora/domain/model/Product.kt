package com.example.sephora.domain.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    @JsonProperty("product_id")
    val productId: Int,
    @JsonProperty("product_name")
    val productName: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("price")
    val price: Int,
    @Embedded
    @JsonProperty("images_url")
    val imagesUrl: ImagesUrl,
    @Embedded
    @JsonProperty("c_brand")
    val cBrand: CBrand,
    @JsonProperty("is_productSet")
    val isProductSet: Boolean,
    @JsonProperty("is_special_brand")
    val isSpecialBrand: Boolean
)