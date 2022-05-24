package com.example.projetofinalquad4.data

import com.example.projetofinalquad4.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ICoinsClient {
    @GET("/v1/assets")
    @Headers("x-api-key: DA13ACA5-BA9A-426D-82B1-E359D401F78E")
    suspend fun getcoins(): List<CoinDto>
}
