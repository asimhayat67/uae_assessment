package com.example.android_assessment_university.utils

import android.os.Build
import android.os.Bundle
import android.os.Parcelable


inline fun <reified T : Parcelable> Bundle.getParcelableExtraBundleCompat(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}