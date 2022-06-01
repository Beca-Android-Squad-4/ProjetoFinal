package com.nttdata.test.backend.networkUtils

import com.example.projetofinalquad4.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        fun get(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(com.example.projetofinalquad4.utils.Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
