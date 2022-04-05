package com.miu.cvbuilder.models

data class WorkExperince(
    val jobTitle: String,
    val company: String,
    val dateFrom: String,
    val dateTo: String,//In case of Present
    val location: String,
    val description: String,
    val image: Int
)