package com.example.fragments

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fragments.BuildConfig.BASE_URL
import com.example.fragments.movie.network.utils.CallMaker
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_second.movie_budget
import kotlinx.android.synthetic.main.fragment_second.movie_overview
import kotlinx.android.synthetic.main.fragment_second.movie_release_date
import kotlinx.android.synthetic.main.fragment_second.movie_revenue
import kotlinx.android.synthetic.main.fragment_second.movie_title
import kotlinx.android.synthetic.main.fragment_second.movie_vote_average
import kotlinx.android.synthetic.main.fragment_second.movie_vote_count
import java.text.NumberFormat

class SecondFragment : Fragment() {

	private var disposables = CompositeDisposable()
	private var movieId: Int? = null
	private lateinit var imgView: ImageView

	override fun onStart() {
		super.onStart()
		getDetailsData(movieId, imgView)
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? = inflater.inflate(R.layout.fragment_second, container, false)

	@SuppressLint("SetTextI18n", "DefaultLocale")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		imgView = view.findViewById<ImageView>(R.id.posterImage)
		movieId = arguments?.getInt("movieId")
	}

	override fun onStop() {
		disposables.clear()
		super.onStop()
	}

	private fun getDetailsData(id: Int?, imageView: ImageView) {
		disposables.add(

			id?.let {
				CallMaker().getDetails(it).subscribe() { details ->
					movie_budget.text =
						if (details.budget == 0) "No data" else NumberFormat.getInstance().format(details.budget) + " $"
					movie_title.text = details.title
					movie_overview.text = details.overview
					movie_revenue.text =
						if (details.revenue == 0) "No data" else NumberFormat.getInstance()
							.format(details.revenue) + " $"
					movie_vote_average.text = details.voteAverage.toString()
					movie_vote_count.text = details.voteCount.toString()
					movie_release_date.text = details.releaseDate
					Picasso
						.get()
						.load(BASE_URL + getString(R.string.movie_poster_width) + details.posterPath)
						.into(imageView)
				}
			}
		)
	}
}
