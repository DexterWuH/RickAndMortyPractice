package com.example.myapplication.remote

import com.example.myapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceProvider {

private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun getLoggingInterceptor(): Interceptor{
        val interceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            } else{
                HttpLoggingInterceptor.Level.NONE
            }
        }
        return interceptor
    }
    private fun getClient(): OkHttpClient {
     return OkHttpClient.Builder()
         .addInterceptor(getLoggingInterceptor())
         .build()
    }
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .client(getClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getRickAndMortyAPI(): RickAndMortyApi {
        return getRetrofit().create(RickAndMortyApi::class.java)
    }
}