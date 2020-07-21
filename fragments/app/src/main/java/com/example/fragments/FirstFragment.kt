package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.MoviesAdapter
import layout.onMovieItemClickListener

class FirstFragment : Fragment(),onMovieItemClickListener {

    lateinit var moviesList: ArrayList<Movie>

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        val rvMovies = rootView.findViewById<View>(R.id.movies_recycler_view) as? RecyclerView
        rvMovies?.layoutManager = LinearLayoutManager(this.context)
        rvMovies?.setHasFixedSize(true)
        moviesList = Movie.createTrialList()
        val moviesAdapter = MoviesAdapter(moviesList,this)
        rvMovies?.adapter = moviesAdapter
        return rootView
    }

    override fun onItemClick(item: Movie, position: Int) {
        val bundle = Bundle()
        bundle.putString("movieTitle",item.title)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        switchToSecondFragment(secondFragment)

    }
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = getView()?.findViewById(R.id.switch_button) as Button
        button.setOnClickListener(){
            val secondFragment = SecondFragment()
            switchToSecondFragment(secondFragment)
        }
    }*/


    private fun switchToSecondFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frameLayout,fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
