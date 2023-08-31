package com.example.bottomnavtest

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object TestRepository {

    var testEndPoint: TestEndPoint? = null

    suspend fun networkFactCall(): Response<CatFactData>? {
        if (testEndPoint == null) {
            testEndPoint = createRetrofitInstance().create(TestEndPoint::class.java)
        }

        return testEndPoint?.networkFactCall()

    }

    fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS).build()
            )
            .build()

    }

}