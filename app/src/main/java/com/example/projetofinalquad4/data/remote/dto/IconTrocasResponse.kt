package com.example.projetofinalquad4.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class IconTrocasResponse {
    @Parcelize
    data class MovieResponse(
        @SerializedName("results")
        val coins: List<CoinDetails>

    ) : Parcelable {
        constructor() : this(mutableListOf())
    }
}
