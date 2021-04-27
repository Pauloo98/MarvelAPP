package com.example.desafio03_marvel.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("role")
    val role: String
)