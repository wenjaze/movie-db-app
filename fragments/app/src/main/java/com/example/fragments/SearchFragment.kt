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
import com.example.fragments.movie.Movie
import com.example.fragments.movie.MovieInflater
import layout.MoviesAdapter
import layout.onMovieItemClickListener
import java.util.Timer
import java.util.TimerTask

class SearchFragment : Fragment(), onMovieItemClickListener {

    lateinit var moviesList: ArrayList<Movie>
    lateinit var moviesAdapter: MoviesAdapter

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        moviesList = MovieInflater.createTrialList()
        moviesAdapter = MoviesAdapter(moviesList, this)
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
        rvMovies?.layoutManager = LinearLayoutManager(this.context)
        rvMovies?.adapter = moviesAdapter
    }

    private fun initSearchBar(view: View) {
        val searchField = view.findViewById<View>(R.id.searchField) as? EditText
        var timer = Timer()
        timerSchedule(timer, searchField!!.text)

        searchField?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                timer.cancel()
                timer = Timer()
                if (searchField.text.isNotBlank()) {
                    timerSchedule(timer, searchField!!.text)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
        )

    }

    private fun timerSchedule(timer: Timer, textToWrite: Editable) {
        timer.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {

                Toast.makeText(activity?.applicationContext, textToWrite, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }, 500L)
    }

    override fun onItemClick(item: Movie, position: Int) {
        val bundle = Bundle()
        bundle.putString("movieTitle", item.title)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        switchToSecondFragment(secondFragment)
    }

    private fun switchToSecondFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.run {
            replace(R.id.frameLayout, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
