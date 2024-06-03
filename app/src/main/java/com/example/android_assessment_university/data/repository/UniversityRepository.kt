package com.example.android_assessment_university.data.repository

import com.example.android_assessment_university.data.model.University


interface UniversityRepository {

    suspend fun getUniversities(): List<University>?

}