package com.example.android_assessment_university.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ContextModule {

    @Binds
    @Singleton
    abstract fun bindContext(application: Application): Context
}