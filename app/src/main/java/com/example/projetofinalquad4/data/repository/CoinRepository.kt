package com.example.projetofinalquad4.data.repository

import com.example.projetofinalquad4.data.remote.dto.CoinDetailDto
import com.example.projetofinalquad4.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
