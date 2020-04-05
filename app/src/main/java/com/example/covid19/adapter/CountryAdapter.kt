package com.example.covid19.adapter

import android.os.IInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19.CoronaByCountry
import com.example.covid19.R
import com.example.covid19.model.Corona
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter constructor(val countryList: List<Corona?>, val clickListener: (Corona?, Int) -> Unit) :

    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.txt_Country.text = countryList[position]?.country
        holder?.view?.setOnClickListener { clickListener(countryList[position], position) }

     /*   holder.view.setOnClickListener {
            val interfaceCorona: CoronaByCountry
            *//*val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)*//*
        }*/

    }

    /* fun updateCountryList(newCountryList: List<Country>) {
         countryList.clear()
         countryList.addAll(newCountryList)
         notifyDataSetChanged()
     }*/
}