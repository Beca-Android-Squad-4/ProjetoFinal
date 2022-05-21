package com.example.projetofinalquad4.data.remote.dto

data class LastTrade(
    val price: Double,
    val size: Double,
    val taker_side: String,
    val time_coinapi: String,
    val time_exchange: String,
    val uuid: String
)