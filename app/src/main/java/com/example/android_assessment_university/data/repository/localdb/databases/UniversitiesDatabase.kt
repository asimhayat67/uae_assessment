package com.example.android_assessment_university.data.repository.localdb.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.data.repository.localdb.dao.UniversityDao
import com.example.android_assessment_university.utils.Converters

@Database(entities = [University::class], version = 1)
@TypeConverters(Converters::class)
abstract class UniversitiesDatabase : RoomDatabase() {
    abstract fun getUniversityDao(): UniversityDao
}