package com.example.fragments.movie.network.utils

import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieDetails

interface ServerResponseListener {
	fun getMovies(movies: List<Movie>)
}

interface DetailsResponseListener{
	fun getDetails(details: MovieDetails?)
}