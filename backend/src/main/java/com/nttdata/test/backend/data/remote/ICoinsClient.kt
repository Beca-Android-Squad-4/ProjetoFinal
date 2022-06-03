package com.nttdata.test.backend.data.remote

import com.nttdata.test.backend.data.remote.dto.CoinItem
import com.example.projetofinalquad4.utils.Constants
import retrofit2.http.GET

interface ICoinsClient {
    @GET("v1/assets?apikey=${Constants.API_KEY2}")
    suspend fun getData(): List<CoinItem>
}
