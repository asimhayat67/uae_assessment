package com.example.android_assessment_university.ui.universitylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_assessment_universities.databinding.FragmentUniversityDetailBinding
import com.example.android_assessment_university.data.model.University
import com.example.android_assessment_university.ui.universitylist.UniversityListFragment.Companion.ARG_UNIVERSITY

import com.example.android_assessment_university.utils.getParcelableExtraBundleCompat
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UniversityDetailFragment : Fragment() {

    private lateinit var binding: FragmentUniversityDetailBinding
    private lateinit var university: University

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUniversityDetailBinding.inflate(inflater, container, false)
        activity?.let {
            setOnClickListener()
        }
        getData()

        return binding.root
    }

    private fun setOnClickListener() {
        binding.ivRefresh.setOnClickListener {
            val action =
                UniversityDetailFragmentDirections.actionFragmentDetailToFragmentListing(true)
            findNavController().navigate(action)
        }
    }

    private fun getData() {
        university = arguments?.getParcelableExtraBundleCompat(ARG_UNIVERSITY)!!
        setData()
    }


    private fun setData() {
        binding.apply {
            tvName.text = university.name
            tvState.text = university.state_province
            tvCountry.text = university.country
            llState.isVisible = !(university.state_province?.isEmpty() == true || university.state_province.toString() == "null")
            try {
                tvWebPage.text = university.web_pages[0]
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}
