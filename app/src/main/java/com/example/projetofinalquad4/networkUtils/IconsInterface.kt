package com.example.projetofinalquad4.networkUtils

import com.example.projetofinalquad4.data.remote.dto.CoinDetails
import com.example.projetofinalquad4.data.remote.dto.URLIcone
import retrofit2.Call
import retrofit2.http.GET

interface IconsInterface {
    @GET("/v1/assets?apikey=DA13ACA5-BA9A-426D-82B1-E359D401F78E")
    suspend fun getcoins(): Call<CoinDetails>

    @GET("/v1/assets/icons/png_16?apikey=DA13ACA5-BA9A-426D-82B1-E359D401F78E")
    suspend fun geturl(): Call<URLIcone>
}
