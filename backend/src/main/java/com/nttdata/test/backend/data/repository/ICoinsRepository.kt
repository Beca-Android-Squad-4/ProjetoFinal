package com.nttdata.test.backend.data.repository

import com.nttdata.test.backend.data.remote.dto.CoinItem

interface ICoinsRepository {

    suspend fun getCoins(): List<CoinItem>
}
