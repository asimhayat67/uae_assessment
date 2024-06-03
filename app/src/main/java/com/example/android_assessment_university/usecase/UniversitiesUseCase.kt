package com.example.android_assessment_university.usecase

import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.data.repository.UniversityRepository

import javax.inject.Inject

class UniversitiesUseCase @Inject constructor(private val universityRepository: UniversityRepository) {
    suspend fun executeFetchAllUniversities(): List<University>? {
        return universityRepository.getUniversities()
    }
}

