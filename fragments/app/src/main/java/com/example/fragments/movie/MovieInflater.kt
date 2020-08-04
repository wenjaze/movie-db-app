package com.example.fragments.movie

class MovieInflater {
    companion object{
        fun createTrialList() : ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            for (i in 1..10){
                movies.add(Movie("MovieTitle"+i,i.toString()))
            }
            return movies
        }
    }

}