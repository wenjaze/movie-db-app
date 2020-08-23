package com.example.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.movie.Movie
import kotlinx.android.synthetic.main.fragment_second.view.movie_id
import kotlinx.android.synthetic.main.fragment_second.view.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.view.movie_title
import kotlinx.android.synthetic.main.fragment_second.view.movie_vote_average

class SecondFragment : Fragment() {

    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        arguments?.let {

            movie = requireArguments().getParcelable("keyData")!!
            Log.d("SECOND_FRAGMENT", movie.id.toString())
            rootView.movie_id.text = movie?.id.toString()
            rootView.movie_release_date.text = movie!!.releaseDate.toString()
            rootView.movie_title.text = movie!!.title
            rootView.movie_vote_average.text = movie.voteAverage.toString()
        }

        return rootView
    }

}
