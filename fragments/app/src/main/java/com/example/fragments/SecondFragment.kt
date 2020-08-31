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
import com.squareup.picasso.Picasso
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
        var baseURL = "https://image.tmdb.org/t/p/w200"
        val imageView = view.findViewById<ImageView>(R.id.posterImage)

        arguments?.getParcelable<Movie>("keyData")?.run {
            Picasso.get().load(baseURL + posterPath).into(imageView)
            movie_title.text = if (originalTitle != title) "TITLE:\n$title\n($originalTitle)" else "TITLE:\n$title"
            movie_vote_count.text = "VOTE COUNT:\n$voteCount"
            movie_original_language.text = "LANGUAGE:\n$originalLanguage".toUpperCase()
            movie_overview.text = "OVERVIEW:\n$overview"
            movie_popularity.text = "POPULARITY:\n$popularity"
            movie_release_date.text = "RELEASE DATE:\n$releaseDate"
            movie_vote_average.text = "VOTE AVERAGE:\n$voteAverage"
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
