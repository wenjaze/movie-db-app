package com.example.fragments.movie.network

import com.example.fragments.movie.Movie

interface ServerResponseListener {
	fun getMovies(movies: List<Movie>)
}
