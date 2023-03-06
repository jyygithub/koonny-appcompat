package com.koonny.sample.retrofit

import retrofit2.http.GET

interface Api {

    @GET("random")
    suspend fun random(): Quote

}