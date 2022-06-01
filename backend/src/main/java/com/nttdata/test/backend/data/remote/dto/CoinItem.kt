package com.nttdata.test.backend.data.remote.dto

data class CoinItem(
    var asset_id: String,
    val data_end: String,
    val data_orderbook_end: String,
    val data_orderbook_start: String,
    val data_quote_end: String,
    val data_quote_start: String,
    val data_start: String,
    val data_symbols_count: Int,
    val data_trade_end: String,
    val data_trade_start: String,
    val id_icon: String?,
    val name: String,
    val type_is_crypto: Int,
    val volume_1day_usd: Double,
    val volume_1hrs_usd: Double,
    val volume_1mth_usd: Double,
    val price_usd: Double,
    var icon_url: String?,
    var isFavorite: Boolean = false
)
