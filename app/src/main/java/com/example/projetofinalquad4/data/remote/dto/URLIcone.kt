package com.example.projetofinalquad4.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class URLIcone(
    @SerializedName("asset_id")
    val asset_id: String?,
    @SerializedName("url")
    val url: String
) : Parcelable {
    constructor() : this("", "")
}
