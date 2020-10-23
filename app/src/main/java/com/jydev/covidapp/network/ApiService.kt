package com.jydev.covidapp.network

import com.jydev.covidapp.network.data.CovidData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/openapi/service/rest/Covid19/getCovid19InfStateJson")
    fun getData(
        @Query("serviceKey",encoded = true) apiKey : String,
        @Query("pageNo") pageNo : Int,
        @Query("numOfRows") rows : Int,
        @Query("startCreateDt") startCreateDt : String,
        @Query("endCreateDt") endCreateDt : String
    ) : Call<CovidData>
}