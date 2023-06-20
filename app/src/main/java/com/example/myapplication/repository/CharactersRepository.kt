package com.example.myapplication.repository

import com.example.myapplication.remote.RickAndMortyApi
import com.example.myapplication.remote.ServiceProvider.getRickAndMortyAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepository(
    private val api: RickAndMortyApi = getRickAndMortyAPI(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CharactersRepositoryContract {

    override suspend fun getCharacters(): List<Character> {
        return withContext(dispatcher){
            val response = api.getCharacters()
            return@withContext response.results
        }
    }
}


interface CharactersRepositoryContract {
    suspend fun getCharacters(): List<Character>
}