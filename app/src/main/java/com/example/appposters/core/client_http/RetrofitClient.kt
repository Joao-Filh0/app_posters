package com.example.appposters.core.client_http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {


    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private lateinit var INSTANCE: Retrofit
        private fun getInstance(): Retrofit {
            if (!::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <S> request(service: Class<S>): S {
            return getInstance().create(service)
        }

    }


}