package com.example.desafio03_marvel.model


import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("date")
    val date: String,
    @SerializedName("type")
    val type: String
)