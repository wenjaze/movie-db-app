package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.movie.Movie
import kotlinx.android.synthetic.main.fragment_second.movie_id
import kotlinx.android.synthetic.main.fragment_second.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.movie_title
import kotlinx.android.synthetic.main.fragment_second.movie_vote_average

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getParcelable<Movie>("keyData")?.run {
            movie_id.text = id.toString()
            movie_release_date.text = releaseDate.toString()
            movie_title.text = title
            movie_vote_average.text = voteAverage.toString()
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
