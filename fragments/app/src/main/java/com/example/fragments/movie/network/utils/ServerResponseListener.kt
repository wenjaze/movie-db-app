package com.example.fragments.movie.network.utils

import com.example.fragments.movie.network.models.Movie

interface ServerResponseListener {
	fun getMovies(movies: List<Movie>)
}
