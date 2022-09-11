package com.example.githubstar.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TIMEOUT_MILLIS = 15000L
private const val READ_TIMEOUT_MILLIS = 10000L
private const val WRITE_TIMEOUT_MILLIS = 10000L
private const val CALL_TIMEOUT_MILLIS = 10000L

private const val B_END_URL = "https://api.github.com/"

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.SECONDS)
            .callTimeout(CALL_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(B_END_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}