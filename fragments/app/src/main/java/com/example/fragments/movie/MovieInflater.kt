package com.example.fragments.movie

import android.content.Context
import android.util.Log
import java.io.IOException

object MovieInflater {
    // fun movieFromJson(movieJson: MovieJson): Movie {
    //     //val movie = Movie(movieJson.id, movieJson.vote_average, movieJson.title, movieJson.release_date)
    //     //return movie
    // }

    /*fun createMovieList(jsonList: List<MovieJson>): List<Movie> {
        var newList: ArrayList<Movie> = arrayListOf()
        for (i in jsonList) {
            newList.add(movieFromJson(i))
        }
        return newList
    }*/

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
