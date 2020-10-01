package com.example.fragments.movie.network.utils

import android.util.Log
import com.example.fragments.BuildConfig.MOVIE_DB_API_KEY
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieCall : CallBuilder() {
	private var moviesList = emptyList<Movie>()
	fun getMovies(query: String) : List<Movie>?{
		makeMoviesCall(query)
		return moviesList
	}

	private fun makeMoviesCall(query: String) {
		val compositeDisposable = CompositeDisposable()
		compositeDisposable.add(
			buildMoviesCall()
				.listMovies(MOVIE_DB_API_KEY,query)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe({response -> onResponse(response)}, {t -> onFailure(t)})
		)
	}

	private fun onFailure(t: Throwable?) {
		Log.d("Error:",t?.message.toString())
	}

	private fun onResponse(response: MovieResponse?) {
		moviesList = response?.results!!
	}
}