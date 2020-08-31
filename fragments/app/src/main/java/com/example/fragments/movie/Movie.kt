package com.example.fragments.movie

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
	@Json(name = "poster_path")
	val posterPath: String?,
	val overview: String,
	@Json(name = "release_date")
	val releaseDate: String?,
	@Json(name = "original_title")
	val originalTitle: String,
	@Json(name = "original_language")
	val originalLanguage: String,
	val title: String,
	val popularity: Double,
	@Json(name = "vote_count")
	val voteCount: Int,
	@Json(name = "vote_average")
	val voteAverage: Float
) : Parcelable
