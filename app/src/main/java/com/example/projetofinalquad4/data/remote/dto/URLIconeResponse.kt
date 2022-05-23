package com.example.projetofinalquad4.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class URLIconeResponse(
    @SerializedName("results")
    val coins: List<URLIcone>

) : Parcelable {
    constructor() : this(mutableListOf())
}
