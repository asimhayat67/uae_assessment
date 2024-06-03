package com.example.android_assessment_university.data.repository.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_assessment_university.data.model.University


@Dao
abstract class UniversityDao {

    @Insert
    abstract suspend fun insertUniversities(universities: List<University>)

    @Query("SELECT * FROM university")
    abstract suspend fun getUniversities(): List<University>


}


