package com.example.projetofinalquad4.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class IconTrocasResponse(
    @SerializedName("results")
    val coins: List<CoinDetails>

) : Parcelable {
    constructor() : this(mutableListOf())
}
