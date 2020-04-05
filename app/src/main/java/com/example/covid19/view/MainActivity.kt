package com.example.covid19.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19.R
import com.example.covid19.adapter.CountryAdapter
import com.example.covid19.model.Corona
import com.example.covid19.model.ResponseCorona
import com.example.covid19.services.CoronaAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val coronaAPIService = CoronaAPIService()
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        try {
            disposable.add(
                coronaAPIService.getData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response -> onResponse(response) }, { t -> onFailure(t) })
            )
        } catch (e: Exception) {
            Log.d("errorr", e.message.toString())
        }
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: ResponseCorona) {
        txt_Country.text = response.result[0]?.country
        txt_totalCases.text = response.result[0]?.totalcases
        txt_totalDeaths.text = response.result[0]?.totaldeaths
        txt_totalRecovered.text = response.result[0]?.totalRecovered
        txt_newCases.text = response.result[0]?.newCases
        txt_newDeaths.text = response.result[0]?.newDeaths
        txt_activeCases.text = response.result[0]?.activeCases
        val countryAdapter = CountryAdapter(response.result) { itemDto: Corona?, position: Int ->
            txt_Country.text = itemDto?.country
            txt_totalCases.text = itemDto?.totalcases
            txt_totalDeaths.text = itemDto?.totaldeaths
            txt_totalRecovered.text = itemDto?.totalRecovered
            txt_newCases.text = itemDto?.newCases
            txt_newDeaths.text = itemDto?.newDeaths
            txt_activeCases.text = itemDto?.activeCases
        }
        rv_Countries.layoutManager = LinearLayoutManager(applicationContext)
        rv_Countries.adapter = countryAdapter
    }

}