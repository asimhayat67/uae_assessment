package com.example.android_assessment_university.data.repository

import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.data.repository.localdb.LocalDataSource
import com.example.android_assessment_university.data.repository.remote.RemoteDataSource

class UniversityRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : UniversityRepository {

    override suspend fun getUniversities(): List<University>? {
        return try {
            val remoteList = remoteDataSource.fetchAllUniversities()
            if (remoteList?.isNotEmpty() == true) {
                localDataSource.insertUniversities(remoteList)
            }
            remoteList
        } catch (e: Exception) {
            localDataSource.getUniversities()
        }
    }


}
