package com.example.desafio03_marvel.network

import com.example.desafio03_marvel.model.Comics
import com.example.desafio03_marvel.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointAPI {

    @GET("comics?")
    suspend fun getComics(
            @Query("offset") offset: Int?,
            @Query("orderBy") orderBy: String?,
            @Query("ts") ts: String?,
            @Query("hash") hash: String?,
            @Query("apikey") apiKey: String?,
            @Query("characters") characters: Int?,
            @Query("limit") limit: Int?
    ) : Comics


}