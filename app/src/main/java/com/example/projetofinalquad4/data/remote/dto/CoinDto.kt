package com.example.projetofinalquad4.data.remote.dto

data class CoinDto(
    /*val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String*/

    val asset_id: String,
    val name: String,
    val type_is_crypto: Int,
    val data_quote_start: String,
    val data_quote_end: String,
    val data_orderbook_start: String,
    val data_orderbook_end: String,
    val data_trade_start: String,
    val data_trade_end: String,
    val data_symbols_count: Int,
    val volume_1hrs_usd: Double,
    val volume_1day_usd: Double,
    val dvolume_1mth_usd: Double,
    val price_usd: Double,
    val id_icon: String,
    val data_start: String,
    val data_end: String,
    val icon: String
)
fun mockCoinDto() = listOf(
    CoinDto(
        "BTC",
        "Bitcoin",
        1,
        "2014-02-24T17:43:05.0000000Z",
        "2022-05-24T14:06:37.7880000Z",
        "2014-02-24T17:43:05.0000000Z",
        "2020-08-05T14:38:38.3413202Z",
        "2010-07-17T23:09:17.0000000Z",
        "2022-05-24T14:05:02.1070000Z",
        94408,
        8585381812540.09,
        178475903456513.71,
        4605192281483430505.33,
        28645.559378969945931997946351,
        "4caf2b16-a017-4e26-a348-2cea69c34cba",
        "2010-07-17",
        "2022-05-24",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/4caf2b16a0174e26a3482cea69c34cba.png"

    ),
    CoinDto(
        "PLN",
        "Zloty",
        0,
        "2017-08-29T15:47:10.0528025Z",
        "2022-05-24T14:06:27.1890000Z",
        "2017-08-29T15:47:10.0528025Z",
        "2020-08-05T14:37:41.6530000Z",
        "2011-04-05T18:49:48.0000000Z",
        "2022-05-24T14:04:11.0840000Z",
        95,
        311953.71,
        4252118.22,
        139871912.28,
        0.2305111692633130654710834415,
        "3f682b5b-77ec-4d8c-b612-b8ff3ac748f7",
        "2011-04-05",
        "2022-05-24",
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/3f682b5b77ec4d8cb612b8ff3ac748f7.png"
    )
)

fun CoinDto.toCoin(): Coin {
    return Coin(
       /* id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol*/
        asset_id = asset_id,
        name = name,
        type_is_crypto = type_is_crypto,
        data_quote_start = data_quote_start,
        data_quote_end = data_orderbook_end,
        data_orderbook_start = data_orderbook_start,
        data_orderbook_end = data_orderbook_end,
        data_trade_start = data_trade_start,
        data_trade_end = data_trade_end,
        data_symbols_count = data_symbols_count,
        volume_1hrs_usd = volume_1hrs_usd,
        volume_1day_usd = volume_1day_usd,
        volume_1mth_usd = dvolume_1mth_usd,
        price_usd = price_usd,
        id_icon = id_icon,
        data_start = data_start,
        data_end = data_end,
        icon = icon

    )
}
