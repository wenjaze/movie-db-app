package com.example.fragments.movie

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
	val poster_path: String?,
	val overview: String,
	val release_date: String?,
	val original_title: String,
	val original_language: String,
	val title: String,
	val popularity: Double,
	val vote_count: Int,
	val vote_average: Float
) : Parcelable
