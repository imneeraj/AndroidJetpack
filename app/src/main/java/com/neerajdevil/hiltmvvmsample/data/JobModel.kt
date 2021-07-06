package com.neerajdevil.hiltmvvmsample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Job(
    @Expose
    @SerializedName("job_id")
    val jobId: String,
    @Expose
    @SerializedName("job_title")
    val jobTitle: String,
    @Expose
    @SerializedName("location")
    val jobLocation: String,
    @Expose
    @SerializedName("experience")
    val jobExperience: String,
    @Expose
    @SerializedName("company_name")
    val company: String,
    @Expose
    @SerializedName("posted_date")
    val postedDate: String,
    @Expose
    @SerializedName("description")
    val jobDescription: String,
    @Expose
    @SerializedName("applied")
    val isJobApplied: Int,
    @Expose
    @SerializedName("saved")
    val isJobSaved: Int,
)

data class JobModel(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("status_code")
    val status: Int,
    @Expose
    @SerializedName("data")
    val data: JobListData
)

data class JobListData(
    @Expose
    @SerializedName("job_count")
    val jobCount: String,
    @Expose
    @SerializedName("job_list")
    val jobList: List<Job>
)