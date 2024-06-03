package com.example.android_assessment_university.data.repository.localdb


import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.data.repository.localdb.databases.UniversitiesDatabase

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val chatDatabase: UniversitiesDatabase
) {

    suspend fun insertUniversities(universitiesList: List<University>) {
        chatDatabase.getUniversityDao().insertUniversities(universitiesList)
    }

    suspend fun getUniversities(): List<University> {
        return chatDatabase.getUniversityDao().getUniversities()
    }

}