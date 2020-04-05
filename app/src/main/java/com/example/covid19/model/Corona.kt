package com.example.covid19.model

import com.google.gson.annotations.SerializedName

data class Corona(
    @SerializedName("country")
    val country: String?,
    @SerializedName("totalCases")
    val totalcases: String?,
    @SerializedName("newCases")
    val newCases: String?,
    @SerializedName("totalDeaths")
    val totaldeaths:  String?,
    @SerializedName("newDeaths")
    val newDeaths: String?,
    @SerializedName("totalRecovered")
    val totalRecovered: String?,
    @SerializedName("activeCases")
    val activeCases: String?)