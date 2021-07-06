package com.neerajdevil.hiltmvvmsample.ui.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.neerajdevil.hiltmvvmsample.base.BaseFragment
import com.neerajdevil.hiltmvvmsample.databinding.FragmentJobDetailsBinding
import com.neerajdevil.hiltmvvmsample.network.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobDetails : BaseFragment() {
    lateinit var binding: FragmentJobDetailsBinding
    private val viewModel: JobsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = "Job Details"
        if (!::binding.isInitialized) {
            binding = FragmentJobDetailsBinding.inflate(inflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getJobDescription()
        viewModel.jobDetails.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    hideLoading()
                    binding.jdModel = it.data
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
}