package com.koonny.sample.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor {
                        Log.d("retrofit", it)
                    }.apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
//                    redactHeader("Authorization")
                    }).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}