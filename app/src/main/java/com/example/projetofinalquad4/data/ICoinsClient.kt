package com.example.projetofinalquad4.data

import com.example.projetofinalquad4.data.remote.dto.CoinIcons
import com.example.projetofinalquad4.data.remote.dto.CoinTrocas
import retrofit2.http.GET
import retrofit2.http.Path

interface ICoinsClient {

    @GET("/v1/exchanges")
    suspend fun getcoins(): List<CoinTrocas>

    @GET("/v1/exchanges/icons/{iconSize}")
    suspend fun getCoinByIcon(@Path("coinId") coinId: String): CoinIcons
}
