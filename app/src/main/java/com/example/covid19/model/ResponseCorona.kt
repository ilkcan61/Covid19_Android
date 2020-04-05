package com.example.covid19.model

import com.google.gson.annotations.SerializedName

data class ResponseCorona(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("result")
    val result: List<Corona?>)
