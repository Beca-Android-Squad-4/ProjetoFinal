package com.example.projetofinalquad4.data.remote.dto

/*
GET /v1/exchanges/icons/{iconSize}
 */

data class CoinIcons(
    val exchange_id: String,
    val url: String
)