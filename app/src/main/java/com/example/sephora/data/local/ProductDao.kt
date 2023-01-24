package com.example.sephora.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sephora.domain.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<Product>)

    @Query("DELETE FROM product")
    fun deleteAllProducts()

    @Query("SELECT * FROM product")
    fun getProducts(): List<Product>
}