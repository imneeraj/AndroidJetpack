package com.neerajdevil.hiltmvvmsample.repository

import com.neerajdevil.hiltmvvmsample.data.JobDescriptionModel
import com.neerajdevil.hiltmvvmsample.data.JobListData
import com.neerajdevil.hiltmvvmsample.data.JobModel
import com.neerajdevil.hiltmvvmsample.network.ApiService
import com.neerajdevil.hiltmvvmsample.ui.jobs.JobDetails
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class JobsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getJobs(): Response<JobModel> {
        return apiService.getAllJobs().awaitResponse()
    }

    suspend fun getJobDescription(): Response<JobDescriptionModel> {
        return apiService.getJobDescription().awaitResponse()
    }

}