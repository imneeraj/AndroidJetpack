package com.neerajdevil.hiltmvvmsample.ui.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.neerajdevil.hiltmvvmsample.base.BaseFragment
import com.neerajdevil.hiltmvvmsample.data.Job
import com.neerajdevil.hiltmvvmsample.databinding.FragmentJobsListBinding
import com.neerajdevil.hiltmvvmsample.network.Status
import com.neerajdevil.hiltmvvmsample.ui.adapters.RVAJobListing
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobsList : BaseFragment() {

    lateinit var binding: FragmentJobsListBinding
    private val viewModel: JobsViewModel by viewModels()
    lateinit var adapter: RVAJobListing
    var jobList: MutableList<Job> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = "All Jobs"
        if (!::binding.isInitialized) {
            binding = FragmentJobsListBinding.inflate(inflater, container, false)
            viewModel.getAllJobs()
        }
        return binding.root
    }
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    hideLoading()
                    logError("${it.data?.jobList?.size}")
                    binding.count.text = it.data?.jobCount ?: "No jobs found"
                    jobList.addAll(it.data?.jobList ?: mutableListOf())
                    logError("${jobList.size}")
                    adapter.updateJobList(jobList)
                }
                Status.ERROR -> {
                    hideLoading()
                    showError(it?.errorMessage ?: "Something went wrong.")
                }
                Status.LOADING -> {
                    showLoading()
                }
            }
        })

    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        binding.rvAllJobs.layoutManager = linearLayoutManager
        adapter = RVAJobListing(jobList)
        binding.rvAllJobs.adapter = adapter
    }
}