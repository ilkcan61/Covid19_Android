package com.example.covid19

import com.example.covid19.model.Corona

interface CoronaByCountry {
    fun getData(corona: Corona): Corona {
        return corona
    }
}