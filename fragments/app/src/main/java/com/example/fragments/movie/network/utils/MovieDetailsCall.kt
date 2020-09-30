package com.example.fragments.movie.network.utils

import android.util.Log
import com.example.fragments.BuildConfig.MOVIE_DB_API_KEY
import com.example.fragments.movie.network.models.MovieDetails
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailsCall : CallBuilder(){
	fun getDetails(id:Int) = makeDetailsCall(id)

	private fun makeDetailsCall(id: Int){
		val compositeDisposable = CompositeDisposable()
		compositeDisposable.add(
			buildDetailsCall()
				.getDetails(id, MOVIE_DB_API_KEY)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe({response -> onResponse(response)}, {t -> onFailure(t)})
		)
	}

	private fun onFailure(t: Throwable?) {
		Log.d("Error:",t?.message.toString())
	}

	private fun onResponse(response: MovieDetails): MovieDetails = response
}