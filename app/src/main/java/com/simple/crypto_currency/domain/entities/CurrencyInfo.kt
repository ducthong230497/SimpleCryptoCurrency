package com.simple.crypto_currency.domain.entities

import com.google.gson.annotations.SerializedName

data class CurrencyInfo(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String
)
