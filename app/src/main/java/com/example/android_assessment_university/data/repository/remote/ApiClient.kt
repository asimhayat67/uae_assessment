package com.example.android_assessment_university.data.repository.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    var gson = GsonBuilder()
        .serializeNulls()
        .serializeSpecialFloatingPointValues()
        .setLenient()
        .create()

    val client = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            val request = chain.request().newBuilder()
                /* .addHeader(
                    "Authorization",
                    "Bearer " + MyApplication.pref.getToken()
                ) */
                .build()
            chain.proceed(request)
        }
        // Set timeouts
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }.build()

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        retrofit.create(ApiService::class.java)
    }
}
