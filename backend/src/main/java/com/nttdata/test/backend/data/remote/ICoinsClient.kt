package com.nttdata.test.backend.data.remote

import com.example.projetofinalquad4.utils.Constants
import com.nttdata.test.backend.data.remote.dto.CoinItem
import retrofit2.http.GET

interface ICoinsClient {
    @GET("v1/assets?apikey=${Constants.API_KEY}")
    suspend fun getData(): List<CoinItem>
}
