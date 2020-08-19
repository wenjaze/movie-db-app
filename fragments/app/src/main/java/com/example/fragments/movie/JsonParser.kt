package com.example.fragments.movie

import android.util.Log
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable.join
import kotlinx.coroutines.NonCancellable.start
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.String.join
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class JsonParser(val json: String) : Runnable {

    private var movieResultsTotal: Int = 0
    private var movieResultsList: List<MovieJson> = listOf()

    fun buildObject() {
        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<MovieResults> = moshi.adapter(MovieResults::class.java)
        val movieResults = jsonAdapter.fromJson(json)!!
        movieResultsTotal = movieResults.total_results
        movieResultsList = movieResults.results
    }

    override fun run() {
        buildObject()
    }

    fun createObject() {
        Thread(Runnable {
            try {
                run()
            } catch (e: Exception) {
                Log.d("Error", "couldn't run task.")
            }
        }).run()
    }

    fun getTotalResults() = movieResultsTotal
    fun getResultList() = movieResultsList

}