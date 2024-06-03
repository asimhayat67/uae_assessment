package com.example.android_assessment_university.ui.universitylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assessment_universities.databinding.UniversityListAdapterViewBinding
import com.example.android_assessment_university.data.model.University

class UniversityListAdapter(
    val mContext: Context,
    val mData: List<University>,
    private val listener: UniversityClickListener
) : RecyclerView.Adapter<UniversityListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: UniversityListAdapterViewBinding) :

        RecyclerView.ViewHolder(binding.root)

    interface UniversityClickListener {
        fun onItemClick(university: University)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = mData[position]

        holder.binding.tvName.text = currentItem.name
        holder.binding.tvName.text = currentItem.name
        holder.binding.tvState.text = currentItem.state_province
        if (currentItem.state_province?.isEmpty() == true || currentItem.state_province.toString().equals("null"))
            holder.binding.llState.isVisible=false
        else {
            holder.binding.llState.isVisible=true
        }
        holder.binding.parentLayout.setOnClickListener {
            listener.onItemClick(currentItem)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            UniversityListAdapterViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }


}