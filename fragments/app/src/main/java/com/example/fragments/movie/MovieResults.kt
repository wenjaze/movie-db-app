package com.example.fragments.movie

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResults(var total_results: Int, var results: List<MovieJson>)