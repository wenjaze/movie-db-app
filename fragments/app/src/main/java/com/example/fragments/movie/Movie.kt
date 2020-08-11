package com.example.fragments.movie

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(val id: Long, val voteAverage: Double, val title: String, val releaseDate: Int)
