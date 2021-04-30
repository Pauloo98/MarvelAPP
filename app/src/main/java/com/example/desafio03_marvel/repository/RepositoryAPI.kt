package com.example.desafio03_marvel.repository

import com.example.desafio03_marvel.model.Comics
import com.example.desafio03_marvel.network.EndpointAPI
import com.example.desafio03_marvel.network.RetrofitInit


class RepositoryApi {

    private var url = "https://gateway.marvel.com/v1/public/"

    val PUBLIC_KEY: String? = "6eb7e8896ec5850c52515a8a23ee97f0"
    val PRIVATE_KEY: String? = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
    val orderBy: String? = "focDate"
    val characters: Int? = 1009610
    val limit: Int? = 18

    var ts: String? = java.lang.Long.toString(System.currentTimeMillis() / 1000)
    var hash: String? = md5.md5(ts + PRIVATE_KEY + PUBLIC_KEY)

    private var service = EndpointAPI::class

    private val serviceComics = RetrofitInit(url).create(service)

    suspend fun getComicsService(offset : Int = 1): Comics = serviceComics.getComics(
        offset , orderBy, ts, hash, PUBLIC_KEY, characters, limit
    )

}