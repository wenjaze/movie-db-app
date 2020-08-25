package com.example.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragments.movie.Movie
import kotlinx.android.synthetic.main.fragment_second.movie_overview
import kotlinx.android.synthetic.main.fragment_second.movie_popularity
import kotlinx.android.synthetic.main.fragment_second.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.movie_title
import kotlinx.android.synthetic.main.fragment_second.movie_vote_average

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.getParcelable<Movie>("keyData")?.run {
            movie_overview.text = "OVERVIEW:\n $overview"
            movie_popularity.text = "POPULARITY:\n $popularity"
            movie_release_date.text = "RELEASE DATE:\n $release_date"
            movie_title.text = "TITLE:\n $title"
            movie_vote_average.text = "VOTE AVERAGE:\n $vote_average"
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
