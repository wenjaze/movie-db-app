package com.example.fragments

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fragments.movie.Movie
import kotlinx.android.synthetic.main.fragment_second.movie_original_language
import kotlinx.android.synthetic.main.fragment_second.movie_overview
import kotlinx.android.synthetic.main.fragment_second.movie_popularity
import kotlinx.android.synthetic.main.fragment_second.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.movie_title
import kotlinx.android.synthetic.main.fragment_second.movie_vote_average
import kotlinx.android.synthetic.main.fragment_second.movie_vote_count

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imageView = view.findViewById<ImageView>(R.id.posterImage)
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        arguments?.getParcelable<Movie>("keyData")?.run {
            movie_title.text = if (original_title != title) "TITLE:\n$title\n($original_title)" else "TITLE:\n$title"
            movie_vote_count.text = "VOTE COUNT:\n$vote_count"
            movie_original_language.text = "LANGUAGE:\n$original_language".toUpperCase()
            movie_overview.text = "OVERVIEW:\n$overview"
            movie_popularity.text = "POPULARITY:\n$popularity"
            movie_release_date.text = "RELEASE DATE:\n$release_date"
            movie_vote_average.text = "VOTE AVERAGE:\n$vote_average"
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
