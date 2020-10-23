package com.jydev.covidapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiClient {
    private var retrofit : Retrofit? = null
    private val baseUrl = "http://openapi.data.go.kr"
    private val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor()).build()
    val apiKey = "8iR5MQmrKyH5AXpXC66SXD0BUWuPXgxxKwZ%2BrvP3Sp1Bc%2BTed25swukTDVzZkNMJiUrc8XPmlkLp2ICHB2W58Q%3D%3D"


    fun getRetrofit() : Retrofit? {
        return if(retrofit !=null)
            retrofit
        else Retrofit.Builder().baseUrl(baseUrl).client(
            client
        ).addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy()))).build()
    }
    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> println("request=$message") })
        return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}