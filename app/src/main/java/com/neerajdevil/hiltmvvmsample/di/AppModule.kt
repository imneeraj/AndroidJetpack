package com.neerajdevil.hiltmvvmsample.di

import com.neerajdevil.hiltmvvmsample.network.ApiEndpoints
import com.neerajdevil.hiltmvvmsample.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiEndpoints.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
}