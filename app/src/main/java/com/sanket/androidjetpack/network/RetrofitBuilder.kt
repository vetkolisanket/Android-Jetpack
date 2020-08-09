package com.sanket.androidjetpack.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sanket on 07/08/20.
 */
object RetrofitBuilder {

    private const val BASE_URL = "https://api.stackexchange.com/2.2/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService = getRetrofit().create(ApiService::class.java)

}