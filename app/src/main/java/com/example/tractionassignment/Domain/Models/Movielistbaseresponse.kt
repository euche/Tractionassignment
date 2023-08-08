package com.example.tractionassignment.Domain.Models


import com.google.gson.annotations.SerializedName

data class Movielistbaseresponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)