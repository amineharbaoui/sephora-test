package com.example.sephora.data.repository

import com.example.sephora.data.local.ProductDao
import com.example.sephora.data.remote.ProductApi
import com.example.sephora.domain.model.Product
import com.example.sephora.domain.repository.ProductRepository
import com.example.sephora.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi,
    private val dao: ProductDao
) : ProductRepository {

    private val TAG = "ProductRepositoryImpl"

    override suspend fun getProducts(): Flow<Resource<List<Product>>> = flow {

        val localProducts = dao.getProducts()
        emit(Resource.Success(data = localProducts))

        try {
            val remoteProducts = api.getProducts()
            dao.deleteAllProducts()
            dao.insertProducts(remoteProducts)

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Something went wrong! Please try again.",
                    data = localProducts
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach the server, check your internet and try again.",
                    data = localProducts
                )
            )
        }

        val newLocalProducts = dao.getProducts()
        emit(Resource.Success(data = newLocalProducts))
    }.flowOn(Dispatchers.IO)

}