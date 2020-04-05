package com.example.covid19.services

import com.example.covid19.model.Corona
import com.example.covid19.model.ResponseCorona
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CoronaAPIService {
    private val BASE_URL="https://api.collectapi.com"
    private val api= Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CoronaAPI::class.java)

    fun getData(): Single<ResponseCorona> {
        return api.getCountries()
    }
}