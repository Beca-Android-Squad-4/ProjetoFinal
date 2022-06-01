package com.nttdata.test.backend.data.remote.dto

sealed class CoinApiResult <T> {
    class Loading<T> : CoinApiResult<T>()
    class Success<T>(val data: T) : CoinApiResult<T>()
    class Error<T>(val throwable: Throwable) : CoinApiResult<T>()
}
