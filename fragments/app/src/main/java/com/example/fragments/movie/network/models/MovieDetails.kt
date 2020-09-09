package com.example.fragments.movie.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetails(
	@Json(name = "poster_path")
	val posterPath: String?,
	val overview: String,
	@Json(name = "release_date")
	val releaseDate: String?,
	@Json(name = "original_title")
	val originalTitle: String,
	val budget: Int,
	val title: String,
	val revenue: Int,
	@Json(name = "vote_count")
	val voteCount: Int,
	@Json(name = "vote_average")
	val voteAverage: Float
)
