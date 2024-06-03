package com.example.android_assessment_university.ui.universitylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.usecase.UniversitiesUseCase

import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val fetchAllCountriesUseCase: UniversitiesUseCase
) : ViewModel() {
    val countriesListData = MutableLiveData<List<University>?>()

    suspend fun fetchAllUniversities() {
        val list = fetchAllCountriesUseCase.executeFetchAllUniversities()
        countriesListData.postValue(list)
    }


}