package com.example.fragments.movie.network.api

import com.example.fragments.movie.network.models.MovieResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
	@GET("search/movie")
	fun listMovies(
		@Query("api_key") apiKey: String,
		@Query("query") query: String
	): Observable<MovieResponse>
}
