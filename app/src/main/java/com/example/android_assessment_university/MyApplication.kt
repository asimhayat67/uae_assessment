package com.example.android_assessment_university

import android.app.Application

import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        private lateinit var app: MyApplication
        fun getApp(): MyApplication {
            return app
        }
    }

    private val TAG: String = "MyApplication"

    override fun onCreate() {
        super.onCreate()
        app = this

    }



}
