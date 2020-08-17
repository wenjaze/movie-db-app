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
import com.example.fragments.movie.JsonParser
import layout.MoviesAdapter
import java.util.Timer
import java.util.TimerTask

class SearchFragment() : Fragment(), MoviesAdapter.onMovieItemClickListener {

    lateinit var moviesList: ArrayList<Movie>
    lateinit var moviesAdapter: MoviesAdapter

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val jp = JsonParser(this.requireContext())
        moviesList = requireActivity().let { jp.runOnBackgroundThread(it) } as ArrayList<Movie>
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
                    timerSchedule(timer, searchField.text)
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
                requireActivity().runOnUiThread {

                    Toast.makeText(requireActivity().applicationContext, textToWrite, Toast.LENGTH_LONG)
                        .show()
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
}
