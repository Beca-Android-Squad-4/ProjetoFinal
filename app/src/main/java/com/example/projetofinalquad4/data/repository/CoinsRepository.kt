package com.example.projetofinalquad4.data.repository

import com.example.projetofinalquad4.data.remote.ICoinsClient
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsRepository(private val coinsClient: ICoinsClient) : ICoinsRepository {
    override suspend fun getCoins(): List<CoinItem> {
        return withContext(Dispatchers.IO) {
            coinsClient.getData()
        }
    }
}
