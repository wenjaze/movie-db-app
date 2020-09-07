package com.example.fragments.movie.network

import com.example.fragments.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class CallBuilder() {
	private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
	private fun retrofit() = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL_API)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()

	protected fun buildPopularCall(): MoviePopularApi = retrofit().create(MoviePopularApi::class.java)
	protected fun buildMoviesCall(): MovieApi = retrofit().create(MovieApi::class.java)
}