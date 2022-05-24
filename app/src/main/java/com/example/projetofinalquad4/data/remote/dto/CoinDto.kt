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
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/4caf2b16a0174e26a3482cea69c34cba",
    ),
    CoinDto(
        "4131",
        true,
        true,
        "Metacoin",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "41",
        true,
        true,
        "Logcatu",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "441",
        true,
        true,
        "Turiuba",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "2",
        true,
        true,
        "Tupoia",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "51",
        true,
        true,
        "Lambisgoia",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "988",
        true,
        true,
        "Xiro",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "5",
        true,
        true,
        "Lugx",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "6",
        true,
        true,
        "LUTADOR",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "9",
        true,
        true,
        "Lovely",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "0",
        true,
        true,
        "popo",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "6",
        true,
        true,
        "Sao paulo",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    ),
    CoinDto(
        "414",
        true,
        true,
        "hce",
        531,
        "USD",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png",
    )
)

// fun CoinDto.toCoin(): Coin {
//    return Coin(
//        id = id,
//        is_active = is_active,
//        name = name,
//        rank = rank,
//        symbol = symbol
//    )
// }
