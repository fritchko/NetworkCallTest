package com.example.bottomnavtest

import retrofit2.Response
import retrofit2.http.GET

interface TestEndPoint {

    @GET("fact")
    suspend fun networkFactCall(): Response<CatFactData>
}