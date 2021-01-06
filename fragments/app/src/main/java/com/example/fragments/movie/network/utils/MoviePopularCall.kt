package com.example.fragments.movie.network.utils

import android.util.Log
import com.example.fragments.BuildConfig
import com.example.fragments.BuildConfig.MOVIE_DB_API_KEY
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviePopularCall : CallBuilder() {
	fun getPopularMovies(): Observable<List<Movie>> =
		buildPopularCall()
			.listPopularMovies(MOVIE_DB_API_KEY)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.map {
				it.results
			}
}