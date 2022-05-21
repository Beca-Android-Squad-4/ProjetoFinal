package com.example.projetofinalquad4.networkUtils

import com.example.projetofinalquad4.data.remote.dto.CoinIcons
import com.example.projetofinalquad4.data.remote.dto.CoinDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IconsInterface {
    @GET("/v1/exchanges?apikey=DA13ACA5-BA9A-426D-82B1-E359D401F78E")
    suspend fun getcoins(): Call<CoinDetails>

    @GET("/v1/exchanges/icons/{iconSize}")
    suspend fun getCoinByIcon(@Path("coinId") coinId: String): CoinIcons
}
