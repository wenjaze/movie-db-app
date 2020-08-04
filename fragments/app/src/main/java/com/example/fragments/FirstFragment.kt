package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.movie.Movie
import com.example.fragments.movie.MovieInflater
import layout.MoviesAdapter
import layout.onMovieItemClickListener

class FirstFragment : Fragment(), onMovieItemClickListener {

    lateinit var moviesList: ArrayList<Movie>
    lateinit var moviesAdapter: MoviesAdapter

    companion object {
        fun newInstance() = FirstFragment()
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
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        val rvMovies = rootView.findViewById<View>(R.id.moviesRecyclerView) as? RecyclerView
        rvMovies?.layoutManager = LinearLayoutManager(this.context)
        rvMovies?.adapter = moviesAdapter
        return rootView
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
