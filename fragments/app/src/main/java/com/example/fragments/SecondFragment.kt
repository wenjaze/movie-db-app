package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

class SecondFragment : Fragment() {
    var movieTitle: String? = ""

    companion object {
        fun newInstance() = SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        movieTitle = arguments?.getString("movieTitle")
        rootView.movie_title.text = movieTitle
        return rootView
    }
}
