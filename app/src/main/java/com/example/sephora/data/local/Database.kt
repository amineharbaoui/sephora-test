package com.example.sephora.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sephora.domain.model.Product

@Database(
    entities = [Product::class],
    version = 2
)
abstract class Database : RoomDatabase() {

    abstract val productDao: ProductDao

}