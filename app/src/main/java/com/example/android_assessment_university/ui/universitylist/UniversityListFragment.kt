package com.example.android_assessment_university.ui.universitylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.android_assessment_universities.R
import com.example.android_assessment_universities.databinding.FragmentUniversityListBinding
import com.example.android_assessment_university.data.model.University
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class UniversityListFragment : Fragment(), UniversityListAdapter.UniversityClickListener {

    private lateinit var binding: FragmentUniversityListBinding
    private val viewModel: UniversityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUniversityListBinding.inflate(inflater, container, false)
        observeData()
        fetchAllUniversities()
        checkFromFragmentDetailRefresh()
        setUpAdapter(emptyList())
        swipeRefresh()

        return binding.root
    }

    private fun observeData() {
        viewModel.countriesListData.observe(viewLifecycleOwner) {
            lifecycleScope.launch(Dispatchers.Main) {
                if (!it.isNullOrEmpty()) {
                    setUpAdapter(it)
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.some_thing_went_wrong),
                        Toast.LENGTH_LONG
                    ).show()
                }
                binding.progressbar.isVisible = false
            }
        }
    }

    private fun swipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener(OnRefreshListener {
            setUpAdapter(emptyList())
            fetchAllUniversities()
        })
    }

    companion object {
        const val ARG_UNIVERSITY = "argUniversityModel"
        const val CALL_API = "callApi"
    }

    private fun checkFromFragmentDetailRefresh() {
        val callApi = arguments?.getBoolean(CALL_API) ?: false
        if (callApi) {
            fetchAllUniversities()
        }
    }


    private fun fetchAllUniversities() {
        binding.progressbar.isVisible = true
        binding.swipeRefreshLayout.isRefreshing = false

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.fetchAllUniversities()
        }

    }


    private lateinit var adapter: UniversityListAdapter
    private fun setUpAdapter(list: List<University>) {
        lifecycleScope.launch(Dispatchers.Main) {

            adapter = UniversityListAdapter(
                mContext = requireContext(),
                mData = list,
                listener = this@UniversityListFragment
            )
            binding.rvUniversityList.adapter = adapter
        }

    }


    override fun onItemClick(university: University) {
        val args = Bundle().apply {
            putParcelable(ARG_UNIVERSITY, university)
        }
        findNavController().navigate(
            R.id.action_university_to_university_detail, args
        )
    }

}
