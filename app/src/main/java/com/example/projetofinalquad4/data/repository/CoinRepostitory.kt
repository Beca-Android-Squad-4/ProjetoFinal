package com.example.projetofinalquad4.data.repository

import com.example.projetofinalquad4.data.ICoinsClient
import com.example.projetofinalquad4.data.remote.dto.CoinDto


class CoinRepostitory(private val coinClient: ICoinsClient) : ICoinsClient {
    override suspend fun getcoins(): List<CoinDto> {
        return coinClient.getcoins()
    }
}
