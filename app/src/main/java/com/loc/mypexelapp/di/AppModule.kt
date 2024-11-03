package com.loc.mypexelapp.di

import com.loc.mypexelapp.Constants.API_URL
import com.loc.mypexelapp.data.remote.PexelAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInstance(): PexelAPI {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)

        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

            .build()

        return Retrofit
            .Builder()
            .baseUrl(API_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PexelAPI::class.java)
    }


}