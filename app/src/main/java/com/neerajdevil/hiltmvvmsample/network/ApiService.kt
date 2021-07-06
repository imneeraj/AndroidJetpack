package com.neerajdevil.hiltmvvmsample.network

import com.neerajdevil.hiltmvvmsample.data.JobDescriptionModel
import com.neerajdevil.hiltmvvmsample.data.JobModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("16e8bbad-5cc2-45e3-90f7-be11b715fe5b")
    fun getAllJobs(): Call<JobModel>

    @GET("8f3d2010-8b3f-4ff7-a07f-02951c7194c0")
    fun getJobDescription(): Call<JobDescriptionModel>
}