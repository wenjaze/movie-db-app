package com.example.fragments.movie

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(val id: Long, val voteAverage: Double, val title: String, val releaseDate: Int) : Parcelable
