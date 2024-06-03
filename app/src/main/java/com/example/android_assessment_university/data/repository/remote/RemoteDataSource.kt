package com.example.android_assessment_university.data.repository.remote


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.android_assessment_university.data.model.University
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Singleton
class RemoteDataSource @Inject constructor() {

    private val TAG: String = "RemoteDataSource"

    @Inject
    lateinit var context: Context


    suspend fun fetchAllUniversities(): List<University>? {
        val result = ApiClient.instance.fetchAllUniversities()
        return suspendCoroutine<List<University>?> {
            try {
                val apiResult = result.execute()
                if (apiResult.isSuccessful) {
                    Log.e("API Successful ", apiResult.body().toString())
                    val response = apiResult.body()
                    it.resume(response as List<University>)
                } else {
                    Log.e("API Network Error", apiResult.message())
                    it.resume(null)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                it.resumeWithException(e)
            }
        }
    }


}
