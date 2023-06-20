package com.example.myapplication.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Character(
    val name: String,
    @SerializedName("image")
    val imageUrl: String,
    val species:String?
): Serializable
