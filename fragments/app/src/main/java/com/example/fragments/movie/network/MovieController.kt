package com.example.fragments.movie.network

import android.util.Log
import com.example.fragments.movie.network.models.MovieResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class MovieController() {

	private val API_KEY: String = "43a7ea280d085bd0376e108680615c7f"

	fun searchMovies(query: String, serverResponseListener: ServerResponseListener) {
		val movieApi = buildCall()
		makeCall(movieApi, query, serverResponseListener)
	}

	fun buildCall(): MovieApi {
		val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
		val retrofit: Retrofit = Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/3/")
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()
		return retrofit.create(MovieApi::class.java)
	}

	fun makeCall(movieApi: MovieApi, query: String, serverResponseListener: ServerResponseListener) {
		movieApi.listMovies(API_KEY, query).enqueue(object : Callback<MovieResponse> {
			override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
				val movieResponse = response.body()
				serverResponseListener.getMovies(movieResponse!!.results, succes = true)
			}

			override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
				Log.e(MovieController::class.java.simpleName, t.message!!)
			}
		})
	}
}