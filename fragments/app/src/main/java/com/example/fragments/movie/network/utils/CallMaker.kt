package com.example.fragments.movie.network.utils

import com.example.fragments.BuildConfig
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieDetails
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

open class CallMaker : CallBuilder() {

	fun getMovies(query: String): Observable<List<Movie>> = buildMoviesCall()
		.listMovies(BuildConfig.MOVIE_DB_API_KEY, query)
		.observeOn(AndroidSchedulers.mainThread())
		.subscribeOn(Schedulers.io())
		.map {
			it.results
		}

	fun getDetails(id: Int): Observable<MovieDetails> =
		buildDetailsCall()
			.getDetails(id, BuildConfig.MOVIE_DB_API_KEY)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())

	fun getPopularMovies(): Observable<List<Movie>> =
		buildPopularCall()
			.listPopularMovies(BuildConfig.MOVIE_DB_API_KEY)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.map {
				it.results
			}
}