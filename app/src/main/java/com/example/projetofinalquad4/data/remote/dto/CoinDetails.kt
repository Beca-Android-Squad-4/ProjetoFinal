package com.example.projetofinalquad4.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*GET /v1/exchanges
GET /v1/exchanges/{exchange_id}
GET /v1/exchanges?filter_exchange_id={filter_exchange_id}*/

@Parcelize
data class CoinDetails(
    @SerializedName("exchange_id")
    val exchange_id: String?,
    @SerializedName("website")
    val website: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("data_start")
    val data_start: String,
    @SerializedName("data_end")
    val data_end: String,
    @SerializedName("data_quote_start")
    val data_quote_start: String,
    @SerializedName("data_quote_end")
    val data_quote_end: String,
    @SerializedName("data_symbols_count")
    val data_symbols_count: Int,
    @SerializedName("volume_1hrs_usd")
    val volume_1hrs_usd: Int,
    @SerializedName("volume_1day_usd")
    val volume_1day_usd: Int,
    @SerializedName("volume_1mth_usd")
    val volume_1mth_usd: Int,

) : Parcelable {
    constructor() : this("", "", "", "", "", "", "", 0, 0, 0, 0)
}
