package com.example.desafio03_marvel.model


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: String,
    @SerializedName("type")
    val type: String
)