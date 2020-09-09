package com.example.fragments.movie.network.utils

import android.util.Log
import com.example.fragments.BuildConfig.MOVIE_DB_API_KEY
import com.example.fragments.movie.network.models.MovieDetails
import com.example.fragments.movie.network.models.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MovieController() : CallBuilder() {

	fun searchMovies(query: String, serverResponseListener: ServerResponseListener) {
		makeCall(query, serverResponseListener)
	}

	fun getPopularMovies(serverResponseListener: ServerResponseListener) {
		makePopularCall(serverResponseListener)
	}
	fun getDetails(movie_Id:Int,detailsResponseListener: DetailsResponseListener){
		makeDetailsCall(movie_Id,detailsResponseListener)
	}

	private fun makeCall(query: String, serverResponseListener: ServerResponseListener) {
		buildMoviesCall().listMovies(MOVIE_DB_API_KEY, query).enqueue(object : Callback<MovieResponse> {
			override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
				val movieResponse = response.body()
				movieResponse?.results?.let { serverResponseListener.getMovies(it) }
			}

			override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
				Log.e(MovieController::class.java.simpleName, t.message!!)
			}
		})
	}

	private fun makePopularCall(serverResponseListener: ServerResponseListener) {
		buildPopularCall().listPopularMovies(MOVIE_DB_API_KEY).enqueue(object : Callback<MovieResponse> {
			override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
				val movieResponse: MovieResponse? = response.body()
				movieResponse?.results?.let { serverResponseListener.getMovies(it) }
			}

			override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
				Log.e(MovieController::class.java.simpleName, t.message!!)
			}
		})
	}
	private fun makeDetailsCall(id: Int,detailsResponseListener: DetailsResponseListener){
		buildDetailsCall().getDetails(id,MOVIE_DB_API_KEY).enqueue(object:Callback<MovieDetails> {
			override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
				val movieDetails : MovieDetails? = response.body()
				movieDetails.let { detailsResponseListener.getDetails(it) }
			}
			override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
				Log.e(MovieController::class.java.simpleName, t.message!!)
			}
		})
	}
}