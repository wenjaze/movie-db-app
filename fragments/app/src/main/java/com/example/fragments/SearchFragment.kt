package com.example.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.movie.Movie
import com.example.fragments.movie.network.MovieController
import com.example.fragments.movie.network.ServerResponseListener
import layout.MoviesAdapter
import java.util.Timer
import java.util.TimerTask

class SearchFragment() : Fragment(), MoviesAdapter.onMovieItemClickListener {

	lateinit var moviesAdapter: MoviesAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
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
		var timer = Timer()

		searchField?.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(s: Editable?) {
				timer.cancel()
				timer = Timer()
				if (searchField.text.isNotBlank()) {
					fillMovieList(searchField.text.toString())
				}
			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
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
		}, 500L)
	}

	override fun onItemClick(item: Movie, position: Int) {
		val bundle = Bundle()
		bundle.putParcelable("keyData", item)
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

	private fun fillMovieList(query: String) {
		val timer = Timer()
		val movieController = MovieController()
		movieController.searchMovies(query, object : ServerResponseListener {
			override fun getMovies(movies: List<Movie>) {
				if (movies.isNotEmpty()) {
					timerSchedule(timer) { moviesAdapter.setMovies(movies) }
				} else {
					timerSchedule(
						timer
					) {
						Toast.makeText(
							requireActivity().applicationContext,
							"Couldn't find any movies that matches : $query",
							Toast.LENGTH_LONG
						).show()
					}
				}

			}
		})
	}
}
