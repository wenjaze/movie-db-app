package com.example.fragments.movie

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieJson(val id: Long, val vote_average: Double, val title: String, val release_date: Int)