package com.example.fragments.movie

import android.app.Activity
import android.content.Context
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class JsonParser(context: Context) : Runnable {

    private val contextY = context
    private var nestedList: ArrayList<Movie> = arrayListOf<Movie>()

    private fun jsonParse(context: Context): ArrayList<Movie> {
        val json = MovieInflater.getJsonDataFromAsset(context, "movies.json").toString()
        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<MovieResults> = moshi.adapter(MovieResults::class.java)
        val moviesData = jsonAdapter.fromJson(json)
        val moviesHehe: List<MovieJson> = moviesData!!.results
        return createTrialListSecond(moviesHehe, nestedList)
    }

    private fun createTrialListSecond(jsonList: List<MovieJson>, newList: ArrayList<Movie>): ArrayList<Movie> {
        for (i in jsonList) {
            newList.add(MovieInflater.movieFromJson(i))
        }
        return newList
    }

    fun runOnBackgroundThread(activity: Activity): ArrayList<Movie> {
        Thread(Runnable {
            try {
                run()
            } catch (e: Exception) {
                Log.d("Error", "Couldn't run task on : " + Thread.currentThread().name)
            }
        }).start()
        return nestedList
    }

    override fun run() {
        jsonParse(contextY)
    }
}