package com.example.myapplication.remote

import com.example.myapplication.data.RickAndMortyResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters():RickAndMortyResponse


}