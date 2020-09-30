package com.example.fragments.movie.network.utils

import android.util.Log
import com.example.fragments.BuildConfig
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviePopularCall : CallBuilder() {

	fun getMovies(query: String) = makePopularCall(query)

	private fun makePopularCall(query: String){
		val compositeDisposable = CompositeDisposable()
		compositeDisposable.add(
			buildPopularCall()
				.listPopularMovies(BuildConfig.MOVIE_DB_API_KEY)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe({response -> onResponse(response)}, {t -> onFailure(t)})
		)
	}

	private fun onFailure(t: Throwable?) {
		Log.d("Error:",t?.message.toString())
	}

	private fun onResponse(response: MovieResponse?): List<Movie>? = response?.results
}