package com.example.covid19.services

import com.example.covid19.model.Corona
import com.example.covid19.model.ResponseCorona
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoronaAPI {
    @Headers(
        "content-type: application/json",
        "authorization: apikey 6Nra9Sl1LcI7ryeXjSIHCK:6DPCsHW5N91w2DOPTi36yJ"
    )
    @GET("/corona/countriesData")
    fun getCountries(): Single<ResponseCorona>

}