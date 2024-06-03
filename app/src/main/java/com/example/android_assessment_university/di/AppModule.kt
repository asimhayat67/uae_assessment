package com.example.android_assessment_university.di

import android.content.Context
import androidx.room.Room
import com.example.android_assessment_university.data.repository.UniversityRepository
import com.example.android_assessment_university.data.repository.UniversityRepositoryImpl
import com.example.android_assessment_university.data.repository.localdb.LocalDataSource
import com.example.android_assessment_university.data.repository.localdb.databases.UniversitiesDatabase
import com.example.android_assessment_university.data.repository.remote.RemoteDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): UniversitiesDatabase {
        return Room.databaseBuilder(
            context,
            UniversitiesDatabase::class.java,
            "university_database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

    }

    @Provides
    @Singleton
    fun provideCountriesRepository(
        remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource
    ): UniversityRepository {
        return UniversityRepositoryImpl(remoteDataSource, localDataSource)
    }


}
