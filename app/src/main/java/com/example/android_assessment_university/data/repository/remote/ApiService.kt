package com.example.android_assessment_university.data.repository.remote


import com.example.android_assessment_university.data.model.University
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("search?country=United%20Arab%20Emirates")
    fun fetchAllUniversities(): Call<List<University>?>



}
