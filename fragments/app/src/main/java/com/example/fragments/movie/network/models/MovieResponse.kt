package com.example.fragments.movie.network.models

import com.example.fragments.movie.Movie
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(val page: Int, val total_results: Int, val total_pages: Int, val results: List<Movie>)