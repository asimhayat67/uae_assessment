package com.example.android_assessment_university.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromStringList(value: String?): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return if (value == null) null else Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListString(list: List<String>?): String? {
        return if (list == null) null else Gson().toJson(list)
    }
}
