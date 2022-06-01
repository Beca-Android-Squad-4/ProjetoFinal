package com.nttdata.test.backend.data.repository

import com.nttdata.test.backend.data.remote.ICoinsClient
import com.nttdata.test.backend.data.remote.dto.CoinItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsRepository(private val coinsClient: ICoinsClient) : ICoinsRepository {
    override suspend fun getCoins(): List<CoinItem> {
        return withContext(Dispatchers.IO) {
            coinsClient.getData()
        }
    }
}
