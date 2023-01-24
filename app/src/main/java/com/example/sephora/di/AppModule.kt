package com.example.sephora.di

import android.app.Application
import androidx.room.Room
import com.example.sephora.data.local.Database
import com.example.sephora.data.local.ProductDao
import com.example.sephora.data.remote.ProductApi
import com.example.sephora.data.repository.ProductRepositoryImpl
import com.example.sephora.domain.repository.ProductRepository
import com.example.sephora.domain.use_case.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/*
val viewModelModule = module {
    viewModel { ProductViewModel(get(), get()) }
}

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { ProductUseCase(get()) }
}

val apiModule = module {
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
    single { provideProductApi(get()) }
}

val netModule = module {

    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://sephoraios.github.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client)
            .build()
    }

    single { provideCache(androidApplication()) }
    single { provideHttpClient(get()) }
    single { provideRetrofit(get()) }

}

val databaseModule = module {

    fun provideDatabase(application: Application): Database {
        return Room.databaseBuilder(application, Database::class.java, "sephora.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: Database): ProductDao {
        return database.productDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): ProductApi {
        return Retrofit.Builder()
            .baseUrl("https://sephoraios.github.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client)
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): Database {
        return Room.databaseBuilder(application, Database::class.java, "sephora.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: Database): ProductDao {
        return database.productDao
    }


    @Provides
    @Singleton
    fun provideProductRepository(
        productApi: ProductApi,
        productDao: ProductDao
    ): ProductRepository {
        return ProductRepositoryImpl(productApi, productDao)
    }


    @Provides
    @Singleton
    fun provideProductUseCase(productRepository: ProductRepository): ProductUseCase {
        return ProductUseCase(productRepository)
    }
}