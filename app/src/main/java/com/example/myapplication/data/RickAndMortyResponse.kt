package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    val metaData: ResponseMetaData,
    val results: List<Character>


)

data class ResponseMetaData(

    @SerializedName("count")
    val totalCharactersCount: Int,
    @SerializedName("pages")
    val totalCharacterPages: Int,
    @SerializedName("next")
    val nextCharactersPage: String?,
    @SerializedName("prev")
    val previousCharactersPage: String?

)