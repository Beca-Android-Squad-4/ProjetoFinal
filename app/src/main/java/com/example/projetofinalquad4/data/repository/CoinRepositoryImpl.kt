package com.example.projetofinalquad4.data.repository
import com.example.projetofinalquad4.data.ICoinsClient
import com.example.projetofinalquad4.data.remote.dto.CoinDetailDto
import com.example.projetofinalquad4.data.remote.dto.CoinDto


class CoinRepositoryImpl @Inject constructor (
    private val api: ICoinsClient
        ): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getcoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}