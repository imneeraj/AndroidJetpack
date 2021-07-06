package com.neerajdevil.hiltmvvmsample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JobDescriptionModel(
    @Expose
    @SerializedName("data")
    val data: List<JobDetails>,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("status_code")
    val status_code: Int
)

data class JobDetails(
    @Expose
    @SerializedName("applied")
    val applied: String,
    @Expose
    @SerializedName("company_name")
    val company_name: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("experience")
    val experience: String,
    @Expose
    @SerializedName("industry_name")
    val industry_name: String,
    @Expose
    @SerializedName("job_category")
    val job_category: String,
    @Expose
    @SerializedName("job_title")
    val job_title: String,
    @Expose
    @SerializedName("job_type")
    val job_type: String,
    @Expose
    @SerializedName("location")
    val location: String,
    @Expose
    @SerializedName("posted_date")
    val posted_date: String,
    @Expose
    @SerializedName("qualification_name")
    val qualification_name: String,
    @Expose
    @SerializedName("salary")
    val salary: String,
    @Expose
    @SerializedName("saved")
    val saved: Int,
    @Expose
    @SerializedName("skills")
    val skills: String,
    @Expose
    @SerializedName("vacancies")
    val vacancies: String,
    @Expose
    @SerializedName("walkin_status")
    val walk_in_status: String,
    @Expose
    @SerializedName("walk_in_venue")
    val walk_in_venue: String,
    @Expose
    @SerializedName("walk_in_date")
    val walk_in_date: String,
    @Expose
    @SerializedName("walk_in_time")
    val walk_in_time: String,
    @Expose
    @SerializedName("recruiter_name")
    val recruiter_name: String,
    @Expose
    @SerializedName("recruiter_email")
    val recruiter_email: String,
    @Expose
    @SerializedName("recruiter_contact_number")
    val recruiter_contact_number: String,
    @Expose
    @SerializedName("additional_information")
    val additional_information: String,
    @Expose
    @SerializedName("share_job_title")
    val share_job_title: String,
    @Expose
    @SerializedName("share_job_url")
    val share_job_url: String


)