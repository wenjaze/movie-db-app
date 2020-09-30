package com.example.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.utils.ServerResponseListener
import com.example.fragments.movie.MoviesAdapter
import com.example.fragments.movie.network.utils.MovieCall
import com.example.fragments.movie.network.utils.MoviePopularCall
import java.util.Timer
import java.util.TimerTask

class SearchFragment() : Fragment(), MoviesAdapter.OnMovieItemClickListener {

	lateinit var moviesAdapter: MoviesAdapter
	private var timer = Timer()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		fillPopularMovieList()
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val rootView = inflater.inflate(R.layout.fragment_search, container, false)
		initRecyclerView(rootView)
		initSearchBar(rootView)
		return rootView
	}

	private fun initRecyclerView(view: View) {
		val rvMovies = view.findViewById<View>(R.id.moviesRecyclerView) as? RecyclerView
		moviesAdapter = MoviesAdapter(listOf(), this)
		rvMovies?.layoutManager = LinearLayoutManager(this.requireContext())
		rvMovies?.adapter = moviesAdapter
	}

	private fun initSearchBar(view: View) {
		
		val searchField = view.findViewById<View>(R.id.searchField) as? EditText
		searchField?.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(s: Editable?) {
				if (searchField.text.isNotBlank()) {
					timer.cancel()
					timer = Timer()
					fillMovieList(searchField.text.toString())
				} else {
					fillPopularMovieList()
				}
			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*no-op*/
			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*no-op*/
			}
		}
		)
	}

	private fun timerSchedule(timer: Timer, executeUnit: () -> Unit) {
		timer.schedule(object : TimerTask() {
			override fun run() {
				requireActivity().runOnUiThread {
					executeUnit()
				}
			}
		}, delay)
	}

	override fun onItemClick(item: Movie, position: Int) {
		val bundle = Bundle()
		bundle.putInt("movieId", item.id)
		val secondFragment = SecondFragment()
		secondFragment.arguments = bundle
		switchToSecondFragment(secondFragment)
	}

	private fun switchToSecondFragment(fragment: Fragment) {
		requireActivity().supportFragmentManager.beginTransaction().run {
			replace(R.id.frameLayout, fragment)
			addToBackStack(null)
			commit()
		}
	}

	private fun fillPopularMovieList() {
		val popularMovies = MoviePopularCall()
		val movies = popularMovies.getPopularMovies()
		moviesAdapter.setMovies(movies)
	}

	private fun fillMovieList(query: String) {
		val movieCall = MovieCall()
		val movies = movieCall.getMovies()
		if (movies.isNotEmpty()) {
			timerSchedule(timer) { moviesAdapter.setMovies(movies) }
		}
		else
		{
			timerSchedule(timer) {
				moviesAdapter.clearAdapter()
				Toast.makeText(
					requireActivity().applicationContext,
					"Couldn't find any movies that matches : $query",
					Toast.LENGTH_LONG
				).show()
			}
		}
	}

	companion object {
		const val delay = 500L
	}
}
