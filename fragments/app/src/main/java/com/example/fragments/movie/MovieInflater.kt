package com.example.fragments.movie

import android.content.Context
import android.os.Debug
import android.util.Log
import com.squareup.moshi.Moshi
import java.io.IOException
import java.io.InputStream

class MovieInflater {
    companion object {
        fun movieFromJson(movieJson: MovieJson): Movie {
            val movie = Movie(movieJson.id, movieJson.vote_average, movieJson.title, movieJson.release_date)
            return movie
        }

        fun createTrialList(jsonList: List<MovieJson>): ArrayList<Movie> {
            val adapter: MovieJsonToCamelCaseAdapter
            var newList: ArrayList<Movie> = arrayListOf<Movie>()
            for (i in jsonList) {
                newList.add(movieFromJson(i))
                Log.d("MovieInflater", i.id.toString())
            }
            return newList
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
