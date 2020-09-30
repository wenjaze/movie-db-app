package com.example.fragments

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fragments.BuildConfig.BASE_URL
import com.example.fragments.movie.network.utils.MovieDetailsCall
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_second.movie_budget
import kotlinx.android.synthetic.main.fragment_second.movie_overview
import kotlinx.android.synthetic.main.fragment_second.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.movie_revenue
import kotlinx.android.synthetic.main.fragment_second.movie_title
import kotlinx.android.synthetic.main.fragment_second.movie_vote_average
import kotlinx.android.synthetic.main.fragment_second.movie_vote_count
import java.text.NumberFormat

class SecondFragment : Fragment() {

	override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

	@SuppressLint("SetTextI18n", "DefaultLocale")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val imageView = view.findViewById<ImageView>(R.id.posterImage)
		val movieId = arguments?.getInt("movieId")
		getDetailsData(movieId, imageView)

	}

	private fun getDetailsData(id: Int?, imageView: ImageView) {
		val movieDetails = MovieDetailsCall()
		id?.let { movieDetails.getDetails(it).run{
				movie_budget.text =
					if (budget == 0) "No data" else NumberFormat.getInstance().format(budget) + " $"
				movie_title.text = title
				movie_overview.text = overview
				movie_revenue.text =
					if (revenue == 0) "No data" else NumberFormat.getInstance().format(revenue) + " $"
				movie_vote_average.text = voteAverage.toString()
				movie_vote_count.text = voteCount.toString()
				movie_release_date.text = releaseDate
				Picasso
					.get()
					.load(BASE_URL + getString(R.string.movie_poster_width) + posterPath)
					.into(imageView)
			}
		}
	}

}
