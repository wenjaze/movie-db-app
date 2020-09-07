package com.example.fragments.movie.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
	val page: Int,
	@Json(name="total_results")
	val totalResults: Int,
	@Json(name="total_pages")
	val totalPages: Int,
	val results: List<Movie>
)
