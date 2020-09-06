package com.example.fragments

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fragments.BuildConfig.BASE_URL
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
        val imageView = view.findViewById<ImageView>(R.id.posterImage)
        arguments?.getParcelable<Movie>("keyData")?.run {
            Picasso.get().load(BASE_URL+getString(R.string.movie_poster_width)+posterPath).into(imageView)
            movie_title.text = if (originalTitle != title) title +"\n"+ originalTitle else title
            movie_vote_count.text = voteCount.toString()
            movie_original_language.text = originalLanguage.toUpperCase()
            movie_overview.text = overview
            movie_popularity.text = popularity.toString()
            movie_release_date.text = releaseDate
            movie_vote_average.text = voteAverage.toString()
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
