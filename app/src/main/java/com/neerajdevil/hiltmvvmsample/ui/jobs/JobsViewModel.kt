package com.neerajdevil.hiltmvvmsample.ui.jobs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.neerajdevil.hiltmvvmsample.base.BaseViewModel
import com.neerajdevil.hiltmvvmsample.data.JobDetails
import com.neerajdevil.hiltmvvmsample.data.JobListData
import com.neerajdevil.hiltmvvmsample.network.Resource
import com.neerajdevil.hiltmvvmsample.repository.JobsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsViewModel
@Inject constructor(private val repository: JobsRepository) : BaseViewModel() {

    private val _response = MutableLiveData<Resource<JobListData>>()
    val response = _response

    fun getAllJobs() {
        _response.value = Resource.loading()
        viewModelScope.launch {
            val response = repository.getJobs()
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.status == 0) {
                    _response.value = Resource.success(data.data)
                } else {
                    _response.value =
                        Resource.error(data?.message ?: "Something went wrong PLease try again")
                }
            } else {
                _response.value = Resource.error("Something went wrong PLease try again")
            }
        }
    }

    private val _jobDetails = MutableLiveData<Resource<JobDetails>>()
    val jobDetails = _jobDetails

    fun getJobDescription() {
        _jobDetails.value = Resource.loading()
        viewModelScope.launch {
            val response = repository.getJobDescription()
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.status_code == 0) {
                    _jobDetails.value = Resource.success(data.data[0])
                } else {
                    _jobDetails.value =
                        Resource.error(data?.message ?: "Something went wrong PLease try again")
                }
            } else {
                _jobDetails.value = Resource.error("Something went wrong PLease try again")
            }
        }
    }
}