package com.example.fragments.movie.network.api

import com.example.fragments.movie.network.models.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {
	@GET("movie/{movie_id}")
	fun getDetails(
		@Path("movie_id") movieId:Int?,
		@Query("api_key") apiKey: String
	): Call<MovieDetails>
}