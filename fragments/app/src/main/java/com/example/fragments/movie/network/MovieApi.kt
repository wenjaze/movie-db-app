package com.example.fragments.movie.network

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface MovieApi {
	@GET("search/movie")
	fun listMovies(
		@Query("api_key") apiKey: String,
		@Query("query") query: String
	): Call<MovieResponse>
}