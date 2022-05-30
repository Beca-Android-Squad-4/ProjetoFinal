package com.example.projetofinalquad4.data.remote.dto

sealed class CoinApiResult <T> {
    class Loading<T> : CoinApiResult<T>()
    class Success<T>(val data: T) : CoinApiResult<T>()
    class Error<T>(val throwable: Throwable) : CoinApiResult<T>()
}
