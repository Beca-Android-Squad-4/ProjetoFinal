package com.example.projetofinalquad4.data

import com.example.projetofinalquad4.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ICoinsClient {

    @GET("/v1/coins")
    suspend fun getcoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String)
}
