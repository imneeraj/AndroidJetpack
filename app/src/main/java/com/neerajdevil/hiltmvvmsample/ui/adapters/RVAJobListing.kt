package com.neerajdevil.hiltmvvmsample.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.neerajdevil.hiltmvvmsample.R
import com.neerajdevil.hiltmvvmsample.app_data.AppKeys
import com.neerajdevil.hiltmvvmsample.data.Job
import com.neerajdevil.hiltmvvmsample.databinding.ItemJobListingBinding

class RVAJobListing(private var jobList: MutableList<Job>) :
    RecyclerView.Adapter<RVAJobListing.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemJobListingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Job) {

            with(binding) {
                jobTitle.text = item.jobTitle
                companyName.text = item.company
                experience.text = item.jobExperience
                location.text = item.jobLocation
                jobDescription.text = item.jobDescription
                jobPosted.text = item.postedDate
                jobCard.setOnClickListener {
                    val bundle = bundleOf(
                        AppKeys.QUERY_JOB_ID_KEY to item.jobId
                    )
                    it.findNavController()
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemJobListingBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(jobList[position])

    override fun getItemCount(): Int {
        return jobList.size
    }

    fun updateJobList(list: MutableList<Job>) {
        jobList = list
        notifyDataSetChanged()
    }

    fun clearList() {
        jobList.clear()
        notifyDataSetChanged()
    }
}