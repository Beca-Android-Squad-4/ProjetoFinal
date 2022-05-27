package com.example.projetofinalquad4.data.repository

import com.example.projetofinalquad4.data.remote.dto.CoinItem

interface ICoinsRepository {

    suspend fun getCoins(): List<CoinItem>
}
