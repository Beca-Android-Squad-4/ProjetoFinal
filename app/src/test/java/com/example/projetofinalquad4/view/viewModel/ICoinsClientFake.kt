package com.example.projetofinalquad4.view.viewModel

import com.example.projetofinalquad4.data.remote.ICoinsClient
import com.example.projetofinalquad4.data.remote.dto.CoinItem

class ICoinsClientFake(val string: String) : ICoinsClient {
    override suspend fun getData(): List<CoinItem> {
        return if (string == "OK-200") {
            mockCoinItem
        } else if (string == "ERRO-400") {
            listOf()
        } else listOf()
    }
}

val mockCoinItem = listOf(
    CoinItem(
        "BTC",
        "2022-05-31",
        "2020-08-05T14:38:38.3413202Z",
        "2014-02-24T17:43:05.0000000Z",
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "2010-07-17",
        96002,
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "4caf2b16-a017-4e26-a348-2cea69c34cba",
        "Bitcoin",
        1,
        468686106326247.72,
        1338077368808.34,
        5086694138579370039.52,
        31660.059941379328356677014311,
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/4caf2b16a0174e26a3482cea69c34cba.png",
        null
    ),
    CoinItem(
        "BRL",
        "2022-05-31",
        "2020-08-05T14:38:38.3413202Z",
        "2014-02-24T17:43:05.0000000Z",
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "2010-07-17",
        96002,
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "4caf2b16-a017-4e26-a348-2cea69c34cba",
        "Brasilian Real",
        0,
        468686106326247.72,
        1338077368808.34,
        5086694138579370039.52,
        31660.059941379328356677014311,
        "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/4caf2b16a0174e26a3482cea69c34cba.png",
        null
    ),
    CoinItem(
        "NIS",
        "2022-05-31",
        "2020-08-05T14:38:38.3413202Z",
        "2014-02-24T17:43:05.0000000Z",
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "2010-07-17",
        96002,
        "2022-05-31T18:59:01.1530000Z",
        "2010-07-17T23:09:17.0000000Z",
        "4caf2b16-a017-4e26-a348-2cea69c34cba",
        "NIS",
        0,
        468686106326247.72,
        1338077368808.34,
        5086694138579370039.52,
        31660.059941379328356677014311,
        null,
        null
    )

)
