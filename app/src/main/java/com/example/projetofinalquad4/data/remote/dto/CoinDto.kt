package com.example.projetofinalquad4.data.remote.dto

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun mockCoinDto() = listOf(
    CoinDto(
        "4131",
        true,
        true,
        "Bitcoin",
        51,
        "BTC",
        "https://media.istockphoto.com/vectors/bitcoin-sign-icon-for-internet-money-crypto-currency-symbol-and-coin-vector-id912885640?k=20&m=912885640&s=170667a&w=0&h=mTXiKykLdQnEZ77HJ_IA85hpGODDi-Nh_1e6rP2WWe4=",
    ),
    CoinDto(
        "4131",
        true,
        true,
        "Metacoin",
        531,
        "MTC",
        "https://s2.coinmarketcap.com/static/img/coins/200x200/6498.png",
    )
)

/*fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}*/
