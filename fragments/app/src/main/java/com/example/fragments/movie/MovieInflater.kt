package com.example.fragments.movie

import android.app.Application
import android.content.Context
import android.view.View
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import java.io.IOException
import java.io.InputStream

class MovieInflater {
    companion object {
        fun createTrialList(): ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            for (i in 1..10) {
                movies.add(Movie(20022L, 20141203, "Inception", 8.2))
            }
            return movies
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }

}
